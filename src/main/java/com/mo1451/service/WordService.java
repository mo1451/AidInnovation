/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.WordMapper;
import com.mo1451.model.Word;
import com.mo1451.model.WordExample;
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
	public WordWithBLOBs findWord(int wordId) {
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
}
