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
import javax.jms.Session;
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
import com.mo1451.service.UserService;
import com.mo1451.service.WordService;
import com.mo1451.util.Proper;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private UserService userService;
	private WordService wordService;

	@RequestMapping("/Index")
	public String index(HttpServletRequest request,Model model) {
		
		return "admin/index";
	}
	
	@RequestMapping("/Signin")
	public String Singnin(HttpServletRequest request,Model model) {
		
		return "admin/signin";
	}
	
	@RequestMapping("/CheckAdmin")
	public String CheckAdmin(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && !username.equals("")) {
			if(username.equals("admin") && password.equals("admin")) {
				this.userService.saveAdminCookies(response);
				return "redirect:Index";
			} else {
				String msg = "用户名或密码错误";
				model.addAttribute("msg",msg);
				return "admin/signin";
			}
		}
		return "admin/signin";
	}
	
	@RequestMapping("/UserList")
	public String userList(HttpServletRequest request,Model model) {
		String pageStr = request.getParameter("page");
		
		List<User> users;
		Page p;

		int page = 1;
		int pageSize = Proper.getPageSize();
		
		if(pageStr != null && !pageStr.equals("")) {
			page = Integer.parseInt(pageStr);
		}
		p = new Page(page, pageSize);
		users = this.userService.getUsersByPage(p);
		p.setCount(userService.getUserCount());
		p.resetMaxPage();
		model.addAttribute("users", users);
		model.addAttribute("page", p);
		return "admin/userlist";
	}
	
	@RequestMapping("/userDetail")
	public String userDetail(HttpServletRequest request, Model model) {
		String userIdString = request.getParameter("userId");
		if(userIdString != null && !userIdString.equals("")) {
			int userId = Integer.parseInt(userIdString);
			User user = userService.getUserById(userId);
			model.addAttribute("user",user);
		}
		return "admin/userdetail";
	}
	
	@RequestMapping("/wordList")
	public String wordList(HttpServletRequest request,Model model) {
		String pageStr = request.getParameter("page");
		
		List<Word> words;
		Page p;

		int page = 1;
		int pageSize = Proper.getPageSize();
		
		if(pageStr != null && !pageStr.equals("")) {
			page = Integer.parseInt(pageStr);
		}
		p = new Page(page, pageSize);
		words = this.wordService.getWordsByPage(p);
		p.setCount(this.wordService.getWordCount());
		p.resetMaxPage();
		model.addAttribute("words", words);
		model.addAttribute("page", p);
		return "admin/wordlist";
	}
	
	//不知道为什么session的内容消失
	@RequestMapping("/userSearchList")
	public String userSearchList(HttpServletRequest request, Model model) {
		String userIdString = request.getParameter("userId");
		String userNameString = request.getParameter("userName");
		String userEmailString = request.getParameter("userEmail");
		String pageStr = request.getParameter("page");
		
		int page = 1;
		int pageSize = Proper.getPageSize();
		
		if(pageStr != null && !pageStr.equals("")) {
			page = Integer.parseInt(pageStr);
		}
		
		Page p = new Page(page, pageSize);
		List<User> users = userService.search(userIdString, userNameString, userEmailString, p);	
		p.setCount(userService.getSearchCount(userIdString, userNameString, userEmailString));
		p.resetMaxPage();
		model.addAttribute("users", users);
		model.addAttribute("page", p);
		model.addAttribute("userId", userIdString);
		model.addAttribute("userName", userNameString);
		model.addAttribute("userEmail", userEmailString);
		
		return "admin/usersearchlist";
	}
	
	@RequestMapping("/userSearch")
	public String userSearch(HttpServletRequest request,Model model) {
		String userIdString = request.getParameter("userId");
		String userNameString = request.getParameter("userName");
		String userEmailString = request.getParameter("userEmail");
		String search = request.getParameter("search");
		if(search != null && search.equals("search")) {
			int page = 1;
			int pageSize = Proper.getPageSize();
			Page p = new Page(page, pageSize);
			List<User> users = userService.search(userIdString, userNameString, userEmailString, p);	
			p.setCount(userService.getSearchCount(userIdString, userNameString, userEmailString));
			p.resetMaxPage();
			model.addAttribute("users", users);
			model.addAttribute("page", p);
			model.addAttribute("userId", userIdString);
			model.addAttribute("userName", userNameString);
			model.addAttribute("userEmail", userEmailString);
			return "admin/usersearchlist";
		} else {
			return "admin/usersearch";
		}
		
	}
	
	@RequestMapping("/wordSearch")
	public String wordSearch(HttpServletRequest request,Model model) {
		String wordIdString = request.getParameter("wordId");
		String wordNameString = request.getParameter("wordName");
		String search = request.getParameter("search");
		if(search != null && search.equals("search")) {
			int page = 1;
			int pageSize = Proper.getPageSize();
			Page p = new Page(page, pageSize);
			List<WordSearchResult> wordSearchResults = wordService.search(wordIdString, wordNameString, p);	
			p.setCount(wordService.getSearchCount(wordIdString, wordNameString));
			p.resetMaxPage();
			model.addAttribute("wordSearchResults", wordSearchResults);
			model.addAttribute("page", p);
			model.addAttribute("wordId", wordIdString);
			model.addAttribute("wordName", wordNameString);
			return "admin/wordsearchlist";
		} else {
			return "admin/wordsearch";
		}
		
	}
	
	@RequestMapping("/wordSearchList")
	public String wordSearchList(HttpServletRequest request, Model model) {
		String wordIdString = request.getParameter("wordId");
		String wordNameString = request.getParameter("wordName");
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
		} else {
			Page p = new Page(page, pageSize);
			List<WordSearchResult> wordSearchResults = wordService.search(wordIdString, wordNameString, p);	
			p.setCount(wordService.getSearchCount(wordIdString, wordNameString));
			p.resetMaxPage();
			model.addAttribute("wordSearchResults", wordSearchResults);
			model.addAttribute("page", p);
			model.addAttribute("wordId", wordIdString);
			model.addAttribute("wordName", wordNameString);
		}
		
		
		return "admin/wordsearchlist";
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
}
