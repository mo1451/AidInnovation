/**
 * 
 */
package com.mo1451.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mo1451.model.ProblemDescrWithBLOBs;
import com.mo1451.service.ImgService;
import com.mo1451.service.ProblemDescrService;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class ProblemDescrController {

	private ProblemDescrService problemDescrService;
	private ImgService imgService;
	
	/**
	 * 项目概述
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/projectOverview")
	public String projectOverview(HttpServletRequest request,Model model) {				
		String source = request.getParameter("source");
		String descr = request.getParameter("descr");
		String strWordId = request.getParameter("wordId");
		int wordId = Integer.parseInt(strWordId);
		if(source != null && !source.equals("")) {			
			if(!this.problemDescrService.checkWordId(wordId,source,descr)) {
				this.problemDescrService.addProjectOverview(wordId,source,descr);
			}
			model.addAttribute("source", source);
			model.addAttribute("descr", descr);
		} else {
			ProblemDescrWithBLOBs pdwb = this.problemDescrService.checkWordId(wordId);
			if(pdwb != null) {
				model.addAttribute("source", pdwb.getSource());
				model.addAttribute("descr", pdwb.getDescr());
			}
		}
		model.addAttribute("wordId", wordId);
		return "center/projectOverview";
	}
	
	/**
	 * 发明问题初始形式
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/initialSolution")
	public String initialSolution(HttpServletRequest request,Model model, MultipartFile pictureFile) {				
		String function = request.getParameter("function");
		String component = request.getParameter("component");
		String principle = request.getParameter("principle");
		String mainpro = request.getParameter("mainpro");
		String parameter = request.getParameter("parameter");
		String goal = request.getParameter("goal");
		String restrict = request.getParameter("restrict");
		String existsol = request.getParameter("existsol");
		String strWordId = request.getParameter("wordId");
		int wordId = Integer.parseInt(strWordId);
		if(function != null && !function.equals("")) {			
			
			String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId);  
	        String fileName = "prinImg.png";
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	        	pictureFile.transferTo(targetFile);  
	        	this.imgService.savePrinImgPath(targetFile.getPath(), wordId);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	//        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
			
			if(!this.problemDescrService.checkWordId(wordId,function,component,principle,mainpro,parameter,goal,restrict,existsol)) {
				this.problemDescrService.addinitialSolution(wordId,function,component,principle,mainpro,parameter,goal,restrict,existsol);
			}
			model.addAttribute("function", function);
			model.addAttribute("component", component);
			model.addAttribute("principle", principle);
			model.addAttribute("mainpro", mainpro);
			model.addAttribute("parameter", parameter);
			model.addAttribute("goal", goal);
			model.addAttribute("restrict", restrict);
			model.addAttribute("existsol", existsol);
		} else {
			ProblemDescrWithBLOBs pdwb = this.problemDescrService.checkWordId(wordId);
			if(pdwb != null) {
				model.addAttribute("function", pdwb.getFun());
				model.addAttribute("component", pdwb.getComponent());
				model.addAttribute("principle", pdwb.getPrinciple());
				model.addAttribute("mainpro", pdwb.getProblem());
				model.addAttribute("parameter", pdwb.getParameter());
				model.addAttribute("goal", pdwb.getGoal());
				model.addAttribute("restrict", pdwb.getLim());
				model.addAttribute("existsol", pdwb.getExist());
			}
		}
		model.addAttribute("wordId", wordId);
		return "center/initialSolution";
	}

	public ProblemDescrService getProblemDescrService() {
		return problemDescrService;
	}

	@Resource
	public void setProblemDescrService(ProblemDescrService problemDescrService) {
		this.problemDescrService = problemDescrService;
	}

	public ImgService getImgService() {
		return imgService;
	}

	@Resource
	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}
}
