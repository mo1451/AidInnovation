/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.EvaluateMapper;
import com.mo1451.mapper.WordMapper;
import com.mo1451.model.Evaluate;
import com.mo1451.model.EvaluateExample;
import com.mo1451.model.WordWithBLOBs;

/**
 * @author 默1451
 *
 */
@Service
public class ArrangeAndEvaluateService {
	private EvaluateMapper evaluateMapper;
	private WordMapper wordMapper;

	public EvaluateMapper getEvaluateMapper() {
		return evaluateMapper;
	}

	/**
	 * 获取所有思路
	 * @param wordId
	 * @return
	 */
	public String[] getSolu(int wordId) {
		WordWithBLOBs wwbs = this.wordMapper.selectByPrimaryKey(wordId);
		String[] solu = new String[9];
		solu[0] = wwbs.getCausalsol();
		solu[1] = wwbs.getNinesol();
		solu[2] = wwbs.getResourcesol();
		solu[3] = wwbs.getFunctionsol();
		solu[4] = wwbs.getIdealsol();
		solu[5] = wwbs.getTechsol();
		solu[6] = wwbs.getPhysol();
		solu[7] = wwbs.getObjsol();
		solu[8] = wwbs.getFinalsol();
		return solu;
	}

	public WordMapper getWordMapper() {
		return wordMapper;
	}

	@Resource
	public void setEvaluateMapper(EvaluateMapper evaluateMapper) {
		this.evaluateMapper = evaluateMapper;
	}

	@Resource
	public void setWordMapper(WordMapper wordMapper) {
		this.wordMapper = wordMapper;
	}

	/**
	 * 添加或更新雷达图数据
	 * @param strRadar
	 */
	public void UpdateOrSaveRadar(String[][] strRadar,int wordId) {
		for(int i=0;i<8;i++) {
			if(strRadar[i] != null) {
				int[] radar = new int[strRadar[i].length];
				for(int j=0;j<strRadar[i].length;j++) {
					radar[j] = strRadar[i][j] != null && !strRadar[i][j].equals("") ? Integer.parseInt(strRadar[i][j]) : 0;
				}
				EvaluateExample evaluateExample = new EvaluateExample();
				EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
				criteria.andSoluidEqualTo(i);
				criteria.andWordidEqualTo(wordId);
				List<Evaluate> evals = this.evaluateMapper.selectByExample(evaluateExample);
				if(evals.size() > 0) {
					Evaluate eval = evals.get(0);
					eval.setSoluid(i);
					eval.setComplex(radar[0]);
					eval.setCost(radar[1]);
					eval.setSim(radar[2]);
					eval.setIntell(radar[3]);
					eval.setEquip(radar[4]);
					eval.setFeasi(radar[5]);
					this.evaluateMapper.updateByPrimaryKeySelective(eval);
				} else {
					Evaluate eval = new Evaluate();
					eval.setSoluid(i);
					eval.setComplex(radar[0]);
					eval.setCost(radar[1]);
					eval.setSim(radar[2]);
					eval.setIntell(radar[3]);
					eval.setEquip(radar[4]);
					eval.setFeasi(radar[5]);
					eval.setWordid(wordId);
					this.evaluateMapper.insertSelective(eval);
				}
			}
		}
	}

	/**
	 * 得到雷达图数据
	 * @param wordId
	 * @return
	 */
	public String[][] getRader(int wordId) {
		String[][] str = new String[8][6];
		EvaluateExample evaluateExample = new EvaluateExample();
		EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Evaluate> evals = this.evaluateMapper.selectByExample(evaluateExample);
		for(int i=0;i<8;i++) {
			Evaluate eval = evals.get(i);
			int soluId = eval.getSoluid();
			str[soluId][0] = eval.getComplex() == 0 ? "" : eval.getComplex() + "";
			str[soluId][1] = eval.getCost() == 0 ? "" : eval.getCost() + "";
			str[soluId][2] = eval.getSim() == 0 ? "" : eval.getSim() + "";
			str[soluId][3] = eval.getIntell() == 0 ? "" : eval.getIntell() + "";
			str[soluId][4] = eval.getEquip() == 0 ? "" : eval.getEquip() + "";
			str[soluId][5] = eval.getFeasi() == 0 ? "" :  eval.getFeasi() + "";
		}
		return str;
	}
}
