/**
 * 
 */
package com.mo1451.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mo1451.service.AllService;
import com.mo1451.service.ArrangeAndEvaluateService;
import com.mo1451.service.ProblemDescrService;
import com.mo1451.service.SolveProblemService;
import com.mo1451.service.SystemAnalService;
import com.mo1451.service.WordService;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class WordController {

	private WordService wordService;
	private ProblemDescrService problemDescrService;
	private SolveProblemService solveProblemService;
	private SystemAnalService systemAnalService;
	private ArrangeAndEvaluateService arrangeAndEvaluateService;
	private AllService allService;

	public WordService getWordService() {
		return wordService;
	}

	@Resource
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	
	@RequestMapping("/createWord")
	public String createWord(HttpServletRequest request,HttpServletResponse response,Model model) {
		int wordId = -1;
		String strUserId = request.getParameter("userId");
		String username = request.getParameter("username");
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
		allService.getImgService().createImgTable(wordId);
		model.addAttribute("wordId", wordId);
		model.addAttribute("userId",userId);
		model.addAttribute("username",username);
		return "redirect:Main";
	}
	
	@RequestMapping("/changeWordName")
	public String changeWordName(HttpServletRequest request, Model model, HttpServletResponse response) {
		String wordIdString = request.getParameter("wordId");
		int wordId = 0;
		if(wordIdString != null && !wordIdString.equals("")) {
			wordId = Integer.parseInt(wordIdString);
		} else {
			try {
				response.getWriter().write("<script>window.top.location='../signin'</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		String status = request.getParameter("status");
		String wordName = "未命名";
		if(status != null && status.equals("changed")) {
			wordName = request.getParameter("wordName");
			this.wordService.updateWordName(wordName, wordId);
		} else {
			wordName = this.wordService.getWordNameById(wordId);
		}
		model.addAttribute("wordName", wordName);
		model.addAttribute("wordId", wordId);
		
		return "center/changeWordName";
	}
	
	@RequestMapping(value="/deleteWordJson", produces = "application/json;charset=UTF-8")  
	@ResponseBody
    public String[] deleteWordJson(int wordId) {  
		String str[] = {"删除成功", "删除失败"};  
		allService.deleteWordById(wordId);
        return str;  
    }
	
	@RequestMapping("/saveWord")
	public ResponseEntity<byte[]> saveWord(int wordId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.allService.createWordFile(wordId);
		
		
		String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId + "/word.doc");
		File file = new File(path);
		String dfileName = new String("word.doc".getBytes("UTF-8"), "iso8859-1"); 
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		headers.setContentDispositionFormData("attachment", dfileName); 
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	
	
	public ProblemDescrService getProblemDescrService() {
		return problemDescrService;
	}

	public SolveProblemService getSolveProblemService() {
		return solveProblemService;
	}

	public SystemAnalService getSystemAnalService() {
		return systemAnalService;
	}

	@Resource
	private void setProblemDescrService(ProblemDescrService problemDescrService) {
		this.problemDescrService = problemDescrService;
	}

	@Resource
	private void setSolveProblemService(SolveProblemService solveProblemService) {
		this.solveProblemService = solveProblemService;
	}

	@Resource
	private void setSystemAnalService(SystemAnalService systemAnalService) {
		this.systemAnalService = systemAnalService;
	}

	public ArrangeAndEvaluateService getArrangeAndEvaluateService() {
		return arrangeAndEvaluateService;
	}

	@Resource
	private void setArrangeAndEvaluateService(ArrangeAndEvaluateService arrangeAndEvaluateService) {
		this.arrangeAndEvaluateService = arrangeAndEvaluateService;
	}

	public AllService getAllService() {
		return allService;
	}

	@Resource
	public void setAllService(AllService allService) {
		this.allService = allService;
	}  
	
}
