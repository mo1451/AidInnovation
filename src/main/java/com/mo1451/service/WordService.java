/**
 * 
 */
package com.mo1451.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.WordMapper;
import com.mo1451.model.Page;
import com.mo1451.model.User;
import com.mo1451.model.Word;
import com.mo1451.model.WordExample;
import com.mo1451.model.WordSearch;
import com.mo1451.model.WordSearchResult;
import com.mo1451.model.WordWithBLOBs;

/**
 * @author 默1451
 *
 */
@Service
public class WordService {
	private WordMapper wordMapper;

	public WordMapper getWordMapper() {
		return wordMapper;
	}

	@Resource(name="wordMapper")
	public void setWordMapper(WordMapper wordMapper) {
		this.wordMapper = wordMapper;
	}

	/**
	 * 创建新文档并返回文档id
	 * @param userId
	 */
	public int createNewWord(int userId) {
		WordWithBLOBs wwb = new WordWithBLOBs();
		wwb.setUserid(userId);
		this.wordMapper.insertSelective(wwb);
		return wwb.getId();
	}

	/**
	 * 修改原因1
	 * @param solution1
	 * @param wordId
	 */
	public void updateSolution1(String solution1, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setCausalsol(solution1);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);
	}

	/**
	 * 找到文档
	 * @param wordId
	 * @return
	 */
	public WordWithBLOBs getWordWithBLOBs(int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		return wwbs;
	}

	/**
	 * 修改原因2
	 * @param solution2
	 * @param wordId
	 */
	public void updateSolution2(String solution2, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setNinesol(solution2);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);
	}

	/**
	 * 修改原因3
	 * @param solution3
	 * @param wordId
	 */
	public void updateSolution3(String solution3, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setLifesol(solution3);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);
	}

	/**
	 * 修改原因4
	 * @param solution4
	 * @param wordId
	 */
	public void updateSolution4(String solution4, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setResourcesol(solution4);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);
	}

	/**
	 * 修改原因5
	 * @param solution5
	 * @param wordId
	 */
	public void updateSolution5(String solution5, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setFunctionsol(solution5);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);		
	}

	/**
	 * 修改原因6
	 * @param solution6
	 * @param wordId
	 */
	public void updateSolution6(String solution6, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setIdealsol(solution6);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);		
	}

	/**
	 * 修改原因7
	 * @param solution7
	 * @param wordId
	 */
	public void updateSolution7(String solution7, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setTechsol(solution7);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);	
	}

	/**
	 * 修改原因8
	 * @param solution8
	 * @param wordId
	 */
	public void updateSolution8(String solution8, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setPhysol(solution8);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);	
	}

	/**
	 * 修改原因9
	 * @param solution9
	 * @param wordId
	 */
	public void updateSolution9(String solution9, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setObjsol(solution9);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);	
	}

	/**
	 * 修改最终思路
	 * @param finalSolu
	 * @param wordId
	 */
	public void updateFianlSolu(String finalSolu, int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		wwbs.setFinalsol(finalSolu);
		this.wordMapper.updateByPrimaryKeySelective(wwbs);
	}

	/**
	 * @param userId
	 * @return
	 */
	public List<Word> getWords(int userId) {
		WordExample wordExample = new WordExample();
		WordExample.Criteria criteria = wordExample.createCriteria();
		criteria.andUseridEqualTo(userId);
		return this.wordMapper.selectByExample(wordExample);
	}
	
	public Word getWordById(int wordId) {
		return this.wordMapper.selectByPrimaryKey(wordId);
	}

	/**
	 * @param wordId
	 * @return
	 */
	public String getWordNameById(int wordId) {
		Word w = this.getWordById(wordId);
		return w.getName();
	}

	/**
	 * @param wordName
	 * @param wordId
	 */
	public void updateWordName(String wordName, int wordId) {
		Word w = this.getWordById(wordId);
		w.setName(wordName);
		this.wordMapper.updateByPrimaryKey(w);
	}

	/**
	 * @param wordId
	 */
	public void deleteWord(int wordId) {
		WordExample wordExample = new WordExample();
		WordExample.Criteria criteria = wordExample.createCriteria();
		criteria.andIdEqualTo(wordId);
		this.wordMapper.deleteByExample(wordExample);
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	public Map<? extends String, ? extends Object> saveWord(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.putAll(this.saveSolution(wordId, imgMap));
		return dataMap;
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveSolution(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		if(wwbs != null) {
    		dataMap.put("causalsol", wwbs.getCausalsol());
    		dataMap.put("ninesol", wwbs.getNinesol());
    		dataMap.put("lifesol", wwbs.getLifesol());
    		dataMap.put("resourcesol", wwbs.getResourcesol());
    		dataMap.put("functionsol", wwbs.getFunctionsol());
    		dataMap.put("idealsol", wwbs.getIdealsol());
    		dataMap.put("techsol", wwbs.getTechsol());
    		dataMap.put("physol", wwbs.getPhysol());
    		dataMap.put("objsol", wwbs.getObjsol());
    		dataMap.put("finalsolution", wwbs.getFinalsol());
  /*  		String principleImgPath = Path.getRealPath() + "/images/word" + wordId + "/cauImg.png"; //这是错误的图片，应为原理图，这是因果图
			dataMap.put("principleImg", ImgStr.getImgStr(principleImgPath));
			String causalImgPath = Path.getRealPath() + "/images/word" + wordId + "/cauImg.png";
			dataMap.put("causalImg", ImgStr.getImgStr(causalImgPath));*/
    		dataMap.put("principleImg", imgMap.get("prinImg"));
    		dataMap.put("causalImg", imgMap.get("caulImg"));
    	} else {
    		dataMap.put("causalsol", " ");
    		dataMap.put("ninesol", " ");
    		dataMap.put("lifesol", " ");
    		dataMap.put("resourcesol", " ");
    		dataMap.put("functionsol", " ");
    		dataMap.put("idealsol", " ");
    		dataMap.put("techsol", " ");
    		dataMap.put("physol", " ");
    		dataMap.put("objsol", " ");
    		dataMap.put("finalsolution", " ");
			dataMap.put("principleImg", " ");
			dataMap.put("causalImg", " ");
    	}
		return dataMap;
	}

	/**
	 * @param userId
	 */
	public void deleteWordByUserId(int userId) {
		WordExample wordExample = new WordExample();
		WordExample.Criteria criteria = wordExample.createCriteria();
		criteria.andUseridEqualTo(userId);
		this.wordMapper.deleteByExample(wordExample);
	}

	/**
	 * @param wordId
	 */
	public void deleteAll(int wordId) {
		deleteWord(wordId);
	}

	/**
	 * @param p
	 * @return
	 */
	public List<Word> getWordsByPage(Page p) {
		return wordMapper.selectByPage(p);
	}

	/**
	 * @param wordIdString
	 * @param wordNameString
	 * @param p
	 * @return
	 */
	public List<WordSearchResult> search(String wordIdString, String wordNameString, Page p) {
		WordSearch wordSearch = new WordSearch();
		Word word = new Word();
		if(wordIdString != null && !wordIdString.equals("")) {
			word.setId(Integer.parseInt(wordIdString));
		}
		if(wordNameString != null && !wordNameString.equals("")) {
			word.setName(wordNameString);
		}
		wordSearch.setPage(p);
		wordSearch.setWord(word);
		
		return wordMapper.selectByWordSearch(wordSearch);
	}

	/**
	 * @return
	 */
	public int getWordCount() {
		return wordMapper.countAllWords();
	}

	/**
	 * @param wordIdString
	 * @param wordNameString
	 * @return
	 */
	public int getSearchCount(String wordIdString, String wordNameString) {
		Word word = new Word();
		if(wordIdString != null && !wordIdString.equals("")) {
			word.setId(Integer.parseInt(wordIdString));
		}
		if(wordNameString != null && !wordNameString.equals("")) {
			word.setName(wordNameString);
		}
		return wordMapper.countSearch(word);
	}

	/**
	 * @param userId
	 * @param p
	 * @return
	 */
	public List<WordSearchResult> searchWordsByUserId(int userId, Page p) {
		WordSearch wordSearch = new WordSearch();
		User user = new User();
		user.setId(userId);
		wordSearch.setUser(user);
		wordSearch.setPage(p);
		return wordMapper.selectByUserId(wordSearch);
	}

	/**
	 * @param userId
	 * @return
	 */
	public int getUserIdSearchCount(int userId) {
		User user = new User();
		user.setId(userId);
		return wordMapper.countUserIdSearch(user);
	}
}
