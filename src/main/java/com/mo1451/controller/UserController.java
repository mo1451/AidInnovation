/**
 * 
 */
package com.mo1451.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mo1451.model.Page;
import com.mo1451.model.User;
import com.mo1451.model.Word;
import com.mo1451.model.WordSearchResult;
import com.mo1451.service.AllService;
import com.mo1451.service.UserService;
import com.mo1451.service.WordService;
import com.mo1451.util.Proper;

/**
 * @author 默1451
 *
 */
@Controller
public class UserController {

	private UserService userService;
	private WordService wordService;
	private AllService allservice;

	/**
	 * 注册
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Model model) {		
		return "register";
	}
	
	/**
	 * 添加用户
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model) {
		User u = new User();
		u.setEmail(request.getParameter("email"));
		u.setName(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		UUID uuid = UUID.randomUUID();
		u.setUuid("" + uuid);	
		
		this.userService.addUser(u);
		this.userService.sendCheckMail(u, uuid);
		return "mail";
	}
	
	/**
	 * 验证码ajax
	 * @param session
	 * @param value
	 * @return
	 */
	@RequestMapping("/codeJson")
	public @ResponseBody Map<String,Boolean> codeJson(HttpSession session,String verifycode) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		String code = (String)session.getAttribute("verCode");
		if(code.equalsIgnoreCase(verifycode)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		return map;
	}
	
	/**
	 * 用户ajax
	 * @param username
	 * @return
	 */
	@RequestMapping("/userJson")
	public @ResponseBody Map<String,Boolean> userJson(String username) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		if(this.userService.checkName(username)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		return map;
	}
	
	/**
	 * 邮箱ajax
	 * @param email
	 * @return
	 */
	@RequestMapping("/emailJson")
	public @ResponseBody Map<String, Boolean> eamilJson(String email) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		if(this.userService.checkEmail(email)) {
			map.put("valid", false);
		} else {
			map.put("valid", true);
		}
		return map;
	}
	
	/**
	 * 使用emailJson
	 * 邮箱NotAjax
	 * @param email
	 * @return
	 */
	@Deprecated
	@RequestMapping("/emailNotJson")
	public @ResponseBody Map<String, Boolean> eamilNotJson(String email) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		if(this.userService.checkEmail(email)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		return map;
	}
	
	/**
	 * 用户激活
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/identity")
	public String identity(HttpServletRequest request,Model model) {
		String uuid = request.getParameter("uuid");
		int id = Integer.parseInt(request.getParameter("id"));
		User u = this.userService.getUserById(id); 
		if(this.userService.checkIdentity(u, uuid)) {
			model.addAttribute("msg", "注册链接无效！<br>或许您已激活。");
		} else {
			this.userService.changeIdentityInfo(u);
			model.addAttribute("msg","恭喜您，激活成功！");
		}
		return "checkIdentity";
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/signin")
	public String signIn(HttpServletRequest request,Model model) {
		return "signin";
	}
	
	/**
	 * 检查密码是否正确
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/checkPassword")
	public String checkPassword(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributesModelMap modelMap) {
		String msg = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> users = this.userService.checkPassword(username,password);
		if(users.size() != 0) {
			this.userService.saveUserCookies(response, users.get(0));
			return "redirect:center/userCenter";
		} else {
			msg = "用户名或密码错误";
			model.addAttribute("msg",msg);
			return "signin";
		}
	}
	
	
	
	/**
	 * 用户中心
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/userCenter")
	public String userCenter(HttpServletRequest request, Model model) {
		String strUserId = request.getParameter("userId");
		String strWordId = request.getParameter("wordId");
		String username = request.getParameter("username");
		if(strUserId != null && !strUserId.equals("")) {
			int userId = Integer.parseInt(strUserId);
			int wordId = Integer.parseInt(strWordId);
			model.addAttribute("userId", userId);
			model.addAttribute("wordId",wordId);
			model.addAttribute("username", username);
		} else {
			User u = this.getUserFromCookies(request);
			if(u.getName().equals("admin")) {
				return "redirect:../admin/Index";
			}
			model.addAttribute("userId", u.getId());
			model.addAttribute("username", u.getName());
			
		}
		return "/center/usercenter";
	}
	
	private User getUserFromCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies){
				if (cookie.getName().equals("userId")) {
					int id = Integer.parseInt(cookie.getValue());
					if(id == -1) {
						User user = new User();
						user.setId(-1);
						user.setName("admin");
						return user;
					}
					return this.userService.getUserById(id);
				}
			}
		}
		return null;
	}
	
	/**
	 * 忘记密码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/sendChangePasswordEmail")
	public String sendChangePasswordEmail(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		String msg = "";
		if(email != null && !email.trim().equals("")) {
			UUID uuid = UUID.randomUUID();
			request.getSession().setAttribute("uuid", uuid);
			this.userService.sendResetPasswordEmail(email,uuid);
			msg = "请到邮箱重设你的密码。";
			model.addAttribute("msg", msg);
			return "resetpassword";
		} else {
			msg = "请填写邮箱";
			model.addAttribute("msg", msg);
			return "forgetpassword";
		}		
	}
	
	/**
	 * 重置密码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/resetPassword")
	public String resetPassword(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		String uuid = request.getParameter("uuid");
		String msg = "";
		String u = "" + (UUID) request.getSession().getAttribute("uuid");
		if(uuid.equals(u)) {
			model.addAttribute("email", email);
			return "resetpassword";
		} else {
			msg = "链接失效，请重新激活";
			model.addAttribute("msg", msg);
			return "forgetpassword";
		}
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/changePassword")
	public String changePassword(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String msg = "";
		if(this.userService.changePassword(email,password)) {
			msg = "修改成功";
			model.addAttribute("msg", msg);
			return "changed";
		} else {
			msg = "该用户不存在！";
			model.addAttribute("msg", msg);
			return "forgetpassword";
		}
	}
	
	/**
	 * 主界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/Main")
	public String Main(HttpServletRequest request,Model model) {
		String strUserId = request.getParameter("userId");
		String strWordId = request.getParameter("wordId");
		String username = request.getParameter("username");
		if(strUserId != null && !strUserId.equals("")) {
			int userId = Integer.parseInt(strUserId);
			int wordId = Integer.parseInt(strWordId);
			model.addAttribute("userId", userId);
			model.addAttribute("wordId",wordId);
			model.addAttribute("username", username);
		}
		return "/center/main";
	}
	
	/**
	 * 用户信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/userInfo")
	public String userInfo(HttpServletRequest request,Model model) {
		String strUserId = request.getParameter("userId");
		if(strUserId != null && !strUserId.equals("")) {
			int userId = Integer.parseInt(strUserId);
			User u = this.userService.getUserById(userId);
			model.addAttribute("user", u);
		}
		return "/center/userinfo";
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/changeInfo")
	public String changeInfo(HttpServletRequest request,Model model) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String sex = request.getParameter("sex");
		String industry = request.getParameter("industry");
		String introduction = request.getParameter("introduction");
		User u = this.userService.updateUserInfo(userId,sex,industry,introduction);
		model.addAttribute("user", u);
		return "/center/userinfo";
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/center/changePassword")
	public String changePassword2(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
		String oldPassword = request.getParameter("oldpassword");
		String nowPassword = request.getParameter("nowpassword");
		String name = request.getParameter("name");
		if(name != null && !name.equals("")) {
			List<User> users = this.userService.checkPassword(name, oldPassword);
			String msg = "";
			if(users.size() > 0) {
				this.userService.changePassword(users.get(0).getEmail(), nowPassword);
				msg = "修改成功，请重新登录。";
				model.addAttribute("msg", msg);
				response.getWriter().write("<script>window.top.location='../signin'</script>");
				return null;
			} else {
				msg = "密码错误，修改失败。";
				model.addAttribute("msg", msg);
				return "/center/changepassword";
			}
		} else {
			return "/center/changepassword";
		}
		
	}
	
	/**
	 * 历史文档
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/historyWord")
	public String historyWord(HttpServletRequest request,Model model) {
		/*int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("username");
	//	System.out.println(userId);
		List<Word> words = this.wordService.getWords(userId);
		model.addAttribute("userId", userId);
		model.addAttribute("username", userName);
		model.addAttribute("words", words);
		return "/center/historyword";*/
		
		String pageStr = request.getParameter("page");
		String userIdString = request.getParameter("userId");
		int page = 1;
		int pageSize = Proper.getPageSize();
		
		if(pageStr != null && !pageStr.equals("")) {
			page = Integer.parseInt(pageStr);
		}
		
		if(userIdString != null && !userIdString.equals("")) {
			int userId = Integer.parseInt(userIdString);
			if(pageStr != null && !pageStr.equals("")) {
				page = Integer.parseInt(pageStr);
			}
			Page p = new Page(page, pageSize);
			
			List<WordSearchResult> wordSearchResults = this.wordService.searchWordsByUserId(userId,p);
			p.setCount(wordService.getUserIdSearchCount(userId));
			p.resetMaxPage();
			model.addAttribute("page", p);
			model.addAttribute("wordSearchResults", wordSearchResults);
			model.addAttribute("userId", userId);
		} 
		return "/center/historyword";
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/userOut")
	public String userOut(HttpServletRequest request,Model model, HttpServletResponse response) {
		Cookie cookie = new Cookie("userId", null);
		cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
		return "redirect:signin";
	}
	
	@RequestMapping("/admin/deleteUser")
	public String deleteUser(HttpServletRequest request,Model model) {
		String userIdStr = request.getParameter("userId");
		String pageStr = request.getParameter("page");
		if(userIdStr != null && !userIdStr.equals("")) {
			int userId = Integer.parseInt(userIdStr);
			allservice.deleteUserById(userId);
		}
		return "redirect:UserList?page=" + pageStr;
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public WordService getWordService() {
		return wordService;
	}

	@Resource
	private void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

	public AllService getAllservice() {
		return allservice;
	}

	@Resource
	public void setAllservice(AllService allservice) {
		this.allservice = allservice;
	}
}
