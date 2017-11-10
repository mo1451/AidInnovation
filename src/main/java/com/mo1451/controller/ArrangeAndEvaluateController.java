/**
 * 
 */
package com.mo1451.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mo1451.service.ArrangeAndEvaluateService;
import com.mo1451.service.WordService;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class ArrangeAndEvaluateController {
	private ArrangeAndEvaluateService arrangeAndEvaluteService;
	private WordService wordService;

	public ArrangeAndEvaluateService getArrangeAndEvaluteService() {
		return arrangeAndEvaluteService;
	}

	@Resource
	public void setArrangeAndEvaluteService(ArrangeAndEvaluateService arrangeAndEvaluteService) {
		this.arrangeAndEvaluteService = arrangeAndEvaluteService;
	}
	
	@RequestMapping("/Summer")
	public String Summer(HttpServletRequest request,Model model){		
		int wordId = Integer.parseInt(request.getParameter("wordId"));
		String finalSolu = request.getParameter("solu");
		String[][] strRadar = new String[8][6];
		for(int i=0;i<8;i++) {
			strRadar[i] = request.getParameterValues("radar" + (i+1));
		}
		this.arrangeAndEvaluteService.UpdateOrSaveRadar(strRadar,wordId);
		this.wordService.updateFianlSolu(finalSolu,wordId);
		
		strRadar = this.arrangeAndEvaluteService.getRader(wordId);
		String[] solu = this.arrangeAndEvaluteService.getSolu(wordId);
		model.addAttribute("radar", strRadar);
		model.addAttribute("solu", solu);
		model.addAttribute("wordId", wordId);		
		return "center/summer";
	}

	public WordService getWordService() {
		return wordService;
	}

	@Resource
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
}
