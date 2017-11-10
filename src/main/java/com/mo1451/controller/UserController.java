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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mo1451.model.User;
import com.mo1451.service.UserService;

/**
 * @author 默1451
 *
 */
@Controller
public class UserController {

	private UserService userService;

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
		
		this.userService.addUser(u,uuid);
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
//		System.out.println(code);
//		System.out.println(verifycode);
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
//		System.out.println(username);
		
		if(this.userService.checkName(username)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
//		System.out.println(map);
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
//		System.out.println(username);
		
		if(this.userService.checkEmail(email)) {
			map.put("valid", false);
		} else {
			map.put("valid", true);
		}
//		System.out.println(map);
		return map;
	}
	
	/**
	 * 邮箱NotAjax
	 * @param email
	 * @return
	 */
	@RequestMapping("/emailNotJson")
	public @ResponseBody Map<String, Boolean> eamilNotJson(String email) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
//		System.out.println(username);
		
		if(this.userService.checkEmail(email)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
//		System.out.println(map);
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
//		System.out.println(u.getUuid());
//		System.out.println(uuid);
		if(this.userService.checkIdentity(u, uuid)) {
			model.addAttribute("msg", "注册链接无效！<br>或许您已激活。");
		} else {
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
			modelMap.addFlashAttribute("user", users.get(0));
//			request.getSession().setAttribute("username", users.get(0).getName());
			Cookie cookie = new Cookie("userId", users.get(0).getId().toString());
			cookie.setPath("/");
			cookie.setMaxAge(-1);
	        response.addCookie(cookie);
	        cookie = new Cookie("username", users.get(0).getName());
			cookie.setPath("/");
			cookie.setMaxAge(-1);
	        response.addCookie(cookie);
			return "redirect:center/userCenter";
		} else {
			msg = "用户名或密码错误";
			model.addAttribute("msg",msg);
			return "signin";
		}
	}
	
	/**
	 * 忘记密码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request,Model model) {
		String email = request.getParameter("email");
		String msg = "";
		if(email != null && !email.trim().equals("")) {
			UUID uuid = UUID.randomUUID();
			request.getSession().setAttribute("uuid", uuid);
			this.userService.resetPassword(email,uuid);
			msg = "请到 邮箱重设你的密码。";
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
//		System.out.println(u);
//		System.out.println(uuid);
		if(uuid.equals(u)) {
			msg = "abc";
			model.addAttribute("email", email);
			model.addAttribute("msg", msg);
//			System.out.println("ret");
			return "resetpassword";
		} else {
			msg = "链接失效，请重新激活";
			model.addAttribute("msg", msg);
//			System.out.println("for");
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
			return "changed";
		} else {
			msg = "链接失效，请重新激活";
			model.addAttribute("msg", msg);
//			System.out.println("for");
			return "forgetpassword";
		}
	}
	
	/**
	 * 用户中心
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/center/userCenter")
	public String userCenter(HttpServletRequest request,Model model,@ModelAttribute("user") User user) {
//		System.out.println(user);
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
		return "/center/usercenter";
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
		int userId = Integer.parseInt(request.getParameter("userid"));
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
		
		return "/center/historyword";
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/userOut")
	public String userOut(HttpServletRequest request,Model model) {
		request.getSession().removeAttribute("user");
		Cookie cookie = new Cookie("userId", null);
		cookie.setPath("/");
        cookie.setMaxAge(0);
		return "redirect:signin";
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
