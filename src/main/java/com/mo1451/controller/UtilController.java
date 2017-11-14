/**
 * 
 */
package com.mo1451.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mo1451.util.GenerateCode;

/**
 * @author 默1451
 *
 */
@Controller
public class UtilController {

	@RequestMapping("/VerifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		//生成随机字串 
        String verifyCode = GenerateCode.generateVerifyCode(4); 
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
//        System.out.println(verifyCode);
//        System.out.println(session.getAttribute("verCode"));
        //生成图片 
        int w = 100, h = 30; 
        GenerateCode.outputImage(w, h, response.getOutputStream(), verifyCode); 
	}
}
