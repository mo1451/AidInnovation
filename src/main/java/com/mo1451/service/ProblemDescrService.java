/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.ProblemDescrMapper;
import com.mo1451.model.ProblemDescrExample;
import com.mo1451.model.ProblemDescrWithBLOBs;

/**
 * @author 默1451
 *
 */
@Service
public class ProblemDescrService {
	private ProblemDescrMapper problemDescrMapper;

	public ProblemDescrMapper getProblemDescrMapper() {
		return problemDescrMapper;
	}

	@Resource(name="problemDescrMapper")
	public void setProblemDescrMapper(ProblemDescrMapper problemDescrMapper) {
		this.problemDescrMapper = problemDescrMapper;
	}

	/**
	 * 添加问题来源和描述
	 * @param userId
	 * @param source
	 * @param descr
	 */
	public void addProjectOverview(int wordId, String source, String descr) {
		ProblemDescrWithBLOBs pdwb = new ProblemDescrWithBLOBs();
		pdwb.setDescr(descr);
		pdwb.setSource(source);
		pdwb.setWordid(wordId);
		this.problemDescrMapper.insertSelective(pdwb);
	}

	/**
	 * 检查是否存在问题描述表，若有该表则修改相应字段并返回true，否则返回false---项目描述
	 * @param wordId
	 * @return
	 */
	public boolean checkWordId(int wordId,String source, String descr) {
		// TODO Auto-generated method stub
		ProblemDescrExample problemDescrExample = new ProblemDescrExample();
		ProblemDescrExample.Criteria criteria = problemDescrExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ProblemDescrWithBLOBs> pdwbs = this.problemDescrMapper.selectByExampleWithBLOBs(problemDescrExample);
		if(pdwbs.size() > 0 ) {
			ProblemDescrWithBLOBs pdwb = pdwbs.get(0);
			pdwb.setDescr(descr);
			pdwb.setSource(source);
			this.problemDescrMapper.updateByPrimaryKeyWithBLOBs(pdwb);
			return true;
		}
		return false;
	}
	
	/**
	 * 检查是否存在问题描述表，若有该表则返回该对象，否则返回null
	 * @param wordId
	 * @return
	 */
	public ProblemDescrWithBLOBs checkWordId(int wordId) {
		// TODO Auto-generated method stub
		ProblemDescrExample problemDescrExample = new ProblemDescrExample();
		ProblemDescrExample.Criteria criteria = problemDescrExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ProblemDescrWithBLOBs> pdwbs = this.problemDescrMapper.selectByExampleWithBLOBs(problemDescrExample);
		if(pdwbs.size() > 0 ) {
			ProblemDescrWithBLOBs pdwb = pdwbs.get(0);
			return pdwb;
		}
		return null;
	}

	/**
	 * 检查是否存在问题描述表，若有该表则修改相应字段并返回true，否则返回false---初始形式
	 * @param wordId
	 * @param function
	 * @param component
	 * @param principle
	 * @param mainpro
	 * @param parameter
	 * @param goal
	 * @param restrict
	 * @param existsol
	 * @return
	 */
	public boolean checkWordId(int wordId, String function, String component, String principle, String mainpro,
			String parameter, String goal, String restrict, String existsol) {
		ProblemDescrExample problemDescrExample = new ProblemDescrExample();
		ProblemDescrExample.Criteria criteria = problemDescrExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ProblemDescrWithBLOBs> pdwbs = this.problemDescrMapper.selectByExampleWithBLOBs(problemDescrExample);
		if(pdwbs.size() > 0 ) {
			ProblemDescrWithBLOBs pdwb = pdwbs.get(0);
			pdwb.setFun(function);
			pdwb.setComponent(component);
			pdwb.setPrinciple(principle);
			pdwb.setProblem(mainpro);
			pdwb.setExist(existsol);
			pdwb.setParameter(parameter);
			pdwb.setGoal(goal);
			pdwb.setLim(restrict);
			this.problemDescrMapper.updateByPrimaryKeyWithBLOBs(pdwb);
			return true;
		}
		return false;
	}

	/**
	 * 添加初始形式
	 * @param wordId
	 * @param function
	 * @param component
	 * @param principle
	 * @param mainpro
	 * @param parameter
	 * @param goal
	 * @param restrict
	 * @param existsol
	 */
	public void addinitialSolution(int wordId, String function, String component, String principle, String mainpro,
			String parameter, String goal, String restrict, String existsol) {
		ProblemDescrWithBLOBs pdwb = new ProblemDescrWithBLOBs();
		pdwb.setFun(function);
		pdwb.setComponent(component);
		pdwb.setPrinciple(principle);
		pdwb.setProblem(mainpro);
		pdwb.setExist(existsol);
		pdwb.setParameter(parameter);
		pdwb.setGoal(goal);
		pdwb.setLim(restrict);
		pdwb.setWordid(wordId);
		this.problemDescrMapper.insertSelective(pdwb);
	}	
}
