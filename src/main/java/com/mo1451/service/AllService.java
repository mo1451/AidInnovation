/**
 * 
 */
package com.mo1451.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.model.Word;
import com.mo1451.util.Proper;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author 默1451
 *
 */
@Service
public class AllService {
	private WordService wordService;
	private ArrangeAndEvaluateService arrangeAndEvaluateService;
	private SolveProblemService solveProblemService;
	private SystemAnalService systemAnalService;
	private UserService userService;
	private ProblemDescrService problemDescrService;
	private ImgService imgService;
	
	public WordService getWordService() {
		return wordService;
	}
	public ArrangeAndEvaluateService getArrangeAndEvaluateService() {
		return arrangeAndEvaluateService;
	}
	public SolveProblemService getSolveProblemService() {
		return solveProblemService;
	}
	public SystemAnalService getSystemAnalService() {
		return systemAnalService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	private void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	@Resource
	private void setArrangeAndEvaluateService(ArrangeAndEvaluateService arrangeAndEvaluateService) {
		this.arrangeAndEvaluateService = arrangeAndEvaluateService;
	}
	@Resource
	private void setSolveProblemService(SolveProblemService solveProblemService) {
		this.solveProblemService = solveProblemService;
	}
	@Resource
	private void setSystemAnalService(SystemAnalService systemAnalService) {
		this.systemAnalService = systemAnalService;
	}
	@Resource
	private void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void createWordFile(int wordId) {
		try {
			Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            Map<String, Object> dataMap = this.saveAll(wordId);        	
    		configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("template.ftl");
            String filePath = Proper.getRealPath() + "/images/word" + wordId + "/word.doc";
            File outFile = new File(filePath);
            File parentFile = outFile.getParentFile();
            if(!parentFile.exists()) {
            	parentFile.mkdirs();
            }
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public Map<String, Object> saveAll(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> imgMap = imgService.saveImgService(wordId);
		dataMap.putAll(arrangeAndEvaluateService.saveArrangeAndEvaluate(wordId, imgMap));
		dataMap.putAll(solveProblemService.saveSolveProblem(wordId, imgMap));
		dataMap.putAll(systemAnalService.saveSystemAnalService(wordId, imgMap));
		dataMap.putAll(wordService.saveWord(wordId, imgMap));
		dataMap.putAll(problemDescrService.saveProblemService(wordId));
		return dataMap;
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
	/**
	 * @param userId
	 */
	public void deleteUserById(int userId) {
		this.userService.deleteUserById(userId);
		List<Word> words = wordService.getWords(userId);
		for (Word word : words) {
			deleteWordById(word.getId());
		}
	}
	
	public void deleteWordById(int wordId) {
		arrangeAndEvaluateService.deleteAll(wordId);
		imgService.deleteAll(wordId);
		problemDescrService.deleteAll(wordId);
		solveProblemService.deleteAll(wordId);
		systemAnalService.deleteAll(wordId);
		wordService.deleteAll(wordId);
	}
}
