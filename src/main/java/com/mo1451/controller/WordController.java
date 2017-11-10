/**
 * 
 */
package com.mo1451.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mo1451.service.WordService;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class WordController {

	private WordService wordService;

	public WordService getWordService() {
		return wordService;
	}

	@Resource
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	
	@RequestMapping("/createWord")
	public String createWord(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirects) {
		int wordId = -1;
		String strUserId = request.getParameter("userId");
		System.out.println(strUserId);
		int userId = -1;
		if(strUserId != null && !strUserId.equals("")) {
			userId = Integer.parseInt(strUserId);
		} else {
			try {
				response.getWriter().write("<script>window.top.location='../signin'</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		wordId = this.wordService.createNewWord(userId);
		redirects.addFlashAttribute("wordId", wordId);
		redirects.addFlashAttribute("userId",userId);
		redirects.addFlashAttribute("username",request.getParameter("username"));
//		System.out.println(wordId);
		return "redirect:Main";
	}
	
}
