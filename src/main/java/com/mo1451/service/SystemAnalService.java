/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.CauseMapper;
import com.mo1451.mapper.ComFunMapper;
import com.mo1451.mapper.FunctionMapper;
import com.mo1451.mapper.NinescreenMapper;
import com.mo1451.mapper.SourceMapper;
import com.mo1451.model.Cause;
import com.mo1451.model.CauseExample;
import com.mo1451.model.ComFun;
import com.mo1451.model.ComFunExample;
import com.mo1451.model.Function;
import com.mo1451.model.FunctionExample;
import com.mo1451.model.Ninescreen;
import com.mo1451.model.NinescreenExample;
import com.mo1451.model.Source;
import com.mo1451.model.SourceExample;

/**
 * @author 默1451
 *
 */
@Service
public class SystemAnalService {
	private CauseMapper causeMapper;
	private NinescreenMapper ninescreenMapper;
	private SourceMapper sourceMapper;
	private FunctionMapper functionMapper;
	private ComFunMapper comFunMapper;

	public CauseMapper getCauseMapper() {
		return causeMapper;
	}

	@Resource(name="causeMapper")
	public void setCauseMapper(CauseMapper causeMapper) {
		this.causeMapper = causeMapper;
	}

	/**
	 * 添加原因
	 * @param mainReason
	 * @param reason2
	 * @param reason3
	 */
	public void addCause(String mainReason, String[] reason2, String[][] reason3, int wordId) {
		Cause cause = new Cause();
		cause.setTxt(mainReason);
		cause.setWordid(wordId);
		cause.setPid(0);
		this.causeMapper.insert(cause);
		int id = cause.getId();
		cause.setId(null);
//		System.out.println(id);
		if (reason2 != null) {
			int count2 = reason2.length;
			for (int i = 0; i < count2; i++) {
				cause.setTxt(reason2[i]);
				cause.setPid(id);
				this.causeMapper.insert(cause);
				int id2 = cause.getId();
				cause.setId(null);
				if (reason3 != null) {
					int count3 = reason3[i].length;
					cause.setPid(id2);
					for (int j = 0; j < count3; j++) {
						cause.setTxt(reason3[i][j]);
						this.causeMapper.insert(cause);
						cause.setId(null);
					}
				}
			}
		}

	}

	/**
	 * 检查是否存在原因
	 * @param wordId
	 * @return
	 */
	public List<Cause> checkCause(int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Cause> causes = this.causeMapper.selectByExample(causeExample);
		return causes;
	}

	/**
	 * 添加原因
	 * @param string
	 * @param parameter
	 * @param wordId
	 */
	public void addCause(String name, String text, int wordId) {
		if(name.length() < 11) {
			Cause cause = new Cause();
			int pid = this.findCauseID("mainreason",wordId);
			cause.setName(name);
			cause.setTxt(text);
			cause.setWordid(wordId);
			cause.setPid(pid);
			this.causeMapper.insert(cause);
		} else {
			String pname = name.substring(0, name.length()-3);
			int pid = this.findCauseID(pname,wordId);
			Cause cause = new Cause();
			cause.setName(name);
			cause.setTxt(text);
			cause.setWordid(wordId);
			cause.setPid(pid);
			this.causeMapper.insert(cause);
		}
	}
	
	/**
	 * 找到causeID
	 * @param name
	 * @return
	 */
	public int findCauseID(String name,int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andWordidEqualTo(wordId);
		List<Cause> causes = this.causeMapper.selectByExample(causeExample);
		if(causes.size() > 0) {
			return causes.get(0).getId();
		} else {
			return -1;
		}
	}
	
	/**
	 * 找到Cause
	 * @param name
	 * @return
	 */
	public Cause findCause(String name,int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andWordidEqualTo(wordId);
		List<Cause> causes = this.causeMapper.selectByExample(causeExample);
		if(causes.size() > 0) {
			return causes.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 修改原因
	 * @param string
	 * @param parameter
	 * @param wordId
	 */
	public void updateCause(String name, String text,int wordId) {
		Cause cause = this.findCause(name,wordId);
		cause.setTxt(text);
		this.causeMapper.updateByPrimaryKeySelective(cause);
	}

	/**
	 * 添加或修改主原因
	 * @param string
	 * @param mainReason
	 * @param wordId
	 */
	public void updateMainCause(String name, String text, int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		criteria.andNameEqualTo(name);
		List<Cause> causes = this.causeMapper.selectByExample(causeExample);
		Cause cause = new Cause();
		if(causes.size() > 0) {
			cause = causes.get(0);
			cause.setTxt(text);
			this.causeMapper.updateByPrimaryKeySelective(cause);
		} else {
			cause.setName(name);
			cause.setPid(0);
			cause.setTxt(text);
			cause.setWordid(wordId);
			this.causeMapper.insertSelective(cause);
		}
	}

	/**
	 * 删除原因
	 * @param string
	 */
	public void deleteCause(String name,int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andWordidEqualTo(wordId);
		List<Cause> causes = this.causeMapper.selectByExample(causeExample);
		if(causes.size() > 0) {
			CauseExample causeExample2 = new CauseExample();
			CauseExample.Criteria criteria2 = causeExample2.createCriteria();
			criteria2.andPidEqualTo(causes.get(0).getId());
			criteria2.andWordidEqualTo(wordId);
			this.causeMapper.deleteByExample(causeExample2);
			
		}
		this.causeMapper.deleteByExample(causeExample);
	}

	public NinescreenMapper getNinescreenMapper() {
		return ninescreenMapper;
	}

	@Resource(name="ninescreenMapper")
	public void setNinescreenMapper(NinescreenMapper ninescreenMapper) {
		this.ninescreenMapper = ninescreenMapper;
	}

	/**
	 * 修改或添加screen
	 * @param screen1
	 * @param wordId
	 */
	public Ninescreen updateOrAddScreen(String name, String text, int wordId) {
		NinescreenExample ninescreenExample = new NinescreenExample();
		NinescreenExample.Criteria criteria = ninescreenExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andWordidEqualTo(wordId);
		List<Ninescreen> nss = this.ninescreenMapper.selectByExample(ninescreenExample);
		if(nss.size() > 0) {
			Ninescreen ns = nss.get(0);
			ns.setTxt(text);
			this.ninescreenMapper.updateByPrimaryKeySelective(ns);
			return ns;
		} else {
			Ninescreen ns = new Ninescreen();
			ns.setName(name);
			ns.setWordid(wordId);
			ns.setTxt(text);
			this.ninescreenMapper.insertSelective(ns);
			return ns;
		}
	}

	public SourceMapper getSourceMapper() {
		return sourceMapper;
	}

	@Resource(name="sourceMapper")
	public void setSourceMapper(SourceMapper sourceMapper) {
		this.sourceMapper = sourceMapper;
	}

	/**
	 * 添加或修改资源
	 * @param name
	 * @param type
	 * @param system
	 * @param value
	 * @param quantity
	 * @param quality
	 * @param usable
	 * @param wordId
	 */
	public void addOrUpdateSource(String name, String type, String system, String value, String quantity,
			String quality, String usable, int wordId) {
		SourceExample sourceExample = new SourceExample();
		SourceExample.Criteria criteria = sourceExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		criteria.andNameEqualTo(name);
		List<Source> sources = this.sourceMapper.selectByExample(sourceExample);
		if(sources.size() > 0) {
			Source source = sources.get(0);
			source.setQuality(quality);
			source.setQuantity(quantity);
			source.setSystem(system);
			source.setType(type);
			source.setUsable(usable);
			source.setValue(value);
			this.sourceMapper.updateByPrimaryKey(source);
		} else {
			Source source = new Source();
			source.setQuality(quality);
			source.setQuantity(quantity);
			source.setSystem(system);
			source.setType(type);
			source.setUsable(usable);
			source.setValue(value);
			source.setName(name);
			source.setWordid(wordId);
			this.sourceMapper.insert(source);
		}
	}

	/**
	 * 找到所有资源
	 * @param wordId
	 * @return
	 */
	public List<com.mo1451.model.Source> findSource(int wordId) {
		SourceExample sourceExample = new SourceExample();
		SourceExample.Criteria criteria = sourceExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.sourceMapper.selectByExample(sourceExample);
	}

	/**
	 * 根据名字删除资源
	 * @param deleteValue
	 */
	public void deleteSource(String[] deleteValue) {
		SourceExample sourceExample = new SourceExample();
		SourceExample.Criteria criteria = sourceExample.createCriteria();
		for(int i=0;i<deleteValue.length;i++) {
			criteria.andNameEqualTo(deleteValue[i]);
			this.sourceMapper.deleteByExample(sourceExample);
		}
	}

	public FunctionMapper getFunctionMapper() {
		return functionMapper;
	}

	public ComFunMapper getComFunMapper() {
		return comFunMapper;
	}

	@Resource(name="functionMapper")
	public void setFunctionMapper(FunctionMapper functionMapper) {
		this.functionMapper = functionMapper;
	}
	
	@Resource(name="comFunMapper")
	public void setComFunMapper(ComFunMapper comFunMapper) {
		this.comFunMapper = comFunMapper;
	}

	/**
	 * 添加或修改功能
	 * @param system
	 * @param function
	 * @param component
	 * @param wordId
	 */
	public void addOrUpadate(String system, String function, String component, int wordId) {
		FunctionExample functionExample = new FunctionExample();
		FunctionExample.Criteria criteria = functionExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Function> funs = this.functionMapper.selectByExample(functionExample);
		if(funs.size()>0) {
			Function fun = funs.get(0);
			fun.setSystem(system);
			fun.setComponent(component);
			fun.setFunction(function);
			this.functionMapper.updateByPrimaryKeySelective(fun);
		} else {
			Function fun = new Function();
			fun.setWordid(wordId);
			fun.setSystem(system);
			fun.setComponent(component);
			fun.setFunction(function);
			this.functionMapper.insertSelective(fun);
		}
	}

	/**
	 * 找到功能
	 * @param wordId
	 * @return
	 */
	public List<Function> findFunction(int wordId) {
		FunctionExample functionExample = new FunctionExample();
		FunctionExample.Criteria criteria = functionExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.functionMapper.selectByExample(functionExample);
	}

	/**
	 * 添加关系
	 * @param relative
	 * @param wordId
	 */
	public void addOrUpdateRelative(String[] relative, int wordId) {
		for(int i=0;i<relative.length;i++) {
			if(!relative[i].equals("notrelative")) {
				String[] split = relative[i].split(",");
				
				ComFunExample comFunExample = new ComFunExample();
				ComFunExample.Criteria criteria = comFunExample.createCriteria();
				criteria.andPrenameEqualTo(split[0]);
				criteria.andAfternameEqualTo(split[1]);
				criteria.andWordidEqualTo(wordId);
				List<ComFun> comFuns = this.comFunMapper.selectByExample(comFunExample);
				if(comFuns.size() == 0) {
					ComFun comFun = new ComFun();
					comFun.setPrename(split[0]);
					comFun.setAftername(split[1]);
					comFun.setLevel(1);
					comFun.setType(1);
					comFun.setWordid(wordId);
					this.comFunMapper.insertSelective(comFun);
					comFun = new ComFun();
					comFun.setPrename(split[1]);
					comFun.setAftername(split[0]);
					comFun.setLevel(1);
					comFun.setType(1);
					comFun.setWordid(wordId);
					this.comFunMapper.insertSelective(comFun);
				}
			}
		}
	}

	/**
	 * 寻找关系
	 * @param wordId
	 * @return
	 */
	public List<ComFun> finComFun(int wordId) {
		ComFunExample comFunExample = new ComFunExample();
		ComFunExample.Criteria criteria = comFunExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.comFunMapper.selectByExample(comFunExample);
	}

	/**
	 * 更新功能组件表
	 * @param preAfter
	 * @param func
	 * @param para
	 * @param funtype
	 * @param level
	 * @param wordId
	 */
	public void updateComFun(String[] preAfter, String[] func, String[] para, String[] funtype, String[] level,
			int wordId) {
		if(preAfter != null) {
			for(int i=0;i<preAfter.length;i++) {
				String[] split = preAfter[i].split(",");
				ComFunExample comFunExample = new ComFunExample();
				ComFunExample.Criteria criteria = comFunExample.createCriteria();
				criteria.andPrenameEqualTo(split[0]);
				criteria.andAfternameEqualTo(split[1]);
				criteria.andWordidEqualTo(wordId);
				List<ComFun> cfs = this.comFunMapper.selectByExample(comFunExample);
				if(cfs.size() > 0) {
					ComFun cf = cfs.get(0);
					cf.setFunction(func[i]);
					cf.setLevel(Integer.parseInt(level[i]));
					cf.setPara(para[i]);
					cf.setType(Integer.parseInt(funtype[i]));
					this.comFunMapper.updateByPrimaryKeySelective(cf);
				}
			}
			
		}
	}

	/**
	 * 得到九屏幕
	 * @param wordId
	 * @return
	 */
	public List<Ninescreen> getNineScreens(int wordId) {
		NinescreenExample ninescreenExample = new NinescreenExample();
		NinescreenExample.Criteria criteria = ninescreenExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.ninescreenMapper.selectByExample(ninescreenExample);
	}

}
