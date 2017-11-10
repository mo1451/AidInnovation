/**
 * 
 */
package com.mo1451.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.mo1451.util.ImgStr;
import com.mo1451.util.Proper;

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

	/**
	 * 删除组件
	 * @param txt
	 * @param wordId 
	 */
	public void deleteCom(String txt, int wordId) {
		String[] str = txt.split(",");
		ComFunExample comFunExample = new ComFunExample();
		ComFunExample.Criteria criteria = comFunExample.createCriteria();
		criteria.andPrenameEqualTo(str[0]);
		criteria.andAfternameEqualTo(str[1]);
		criteria.andWordidEqualTo(wordId);
		this.comFunMapper.deleteByExample(comFunExample);
	}

	/**
	 * 添加组件
	 * @param txt
	 * @param wordId
	 */
	public void addCom(String txt, int wordId) {
		String[] str = txt.split(",");
		ComFun cf = new ComFun();
		cf.setAftername(str[1]);
		cf.setPrename(str[0]);
		cf.setWordid(wordId);
		this.comFunMapper.insertSelective(cf);
	}

	/**
	 * 获取功能组件表参数
	 * @param wordId
	 * @param txt 
	 * @return
	 */
	public String[][] getComFunPara(int wordId, String txt) {
		String[] comTxt = txt.split(",");
		ComFunExample comFunExample = new ComFunExample();
		ComFunExample.Criteria criteria = comFunExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ComFun> cfs = this.comFunMapper.selectByExample(comFunExample);
		String[][] str = new String[comTxt.length/2][4];
		for(int i=0;i<str.length;i++) {
			str[i][0] = "";
			str[i][1] = "";
			str[i][2] = 1 + "";
			str[i][3] = 1 + "";
		}
		for(int j=0;j*2<comTxt.length;j++) {
			for(int i=0;i<cfs.size();i++) {
				ComFun cf = cfs.get(i);
				if(cf.getPrename().equals(comTxt[j*2]) && cf.getAftername().equals(comTxt[j*2+1])) {
					str[j][0] = (cf.getFunction()==null?"":cf.getFunction());
					str[j][1] = (cf.getPara()==null?"":cf.getPara());
					str[j][2] = (cf.getType()==null?1:cf.getType()) + "";
					str[j][3] = (cf.getLevel()==null?1:cf.getLevel()) + "";
					break;
				}
			}
		}
		return str;
	}

	/**
	 * @param wordId
	 */
	public void deleteAll(int wordId) {
		this.deleteCause(wordId);
		this.deleteComFun(wordId);
		this.deleteFunction(wordId);
		this.deleteNinescreen(wordId);
		this.deleteSource(wordId);
	}
	
	/**
	 * @param wordId
	 */
	private void deleteSource(int wordId) {
		SourceExample sourceExample = new SourceExample();
		SourceExample.Criteria criteria = sourceExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.sourceMapper.deleteByExample(sourceExample);
	}

	/**
	 * @param wordId
	 */
	private void deleteNinescreen(int wordId) {
		NinescreenExample ninescreenExample = new NinescreenExample();
		NinescreenExample.Criteria criteria = ninescreenExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.ninescreenMapper.deleteByExample(ninescreenExample);
	}

	/**
	 * @param wordId
	 */
	private void deleteFunction(int wordId) {
		FunctionExample functionExample = new FunctionExample();
		FunctionExample.Criteria criteria = functionExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.functionMapper.deleteByExample(functionExample);
	}

	public void deleteCause(int wordId) {
		CauseExample causeExample = new CauseExample();
		CauseExample.Criteria criteria = causeExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.causeMapper.deleteByExample(causeExample);
	}
	
	public void deleteComFun(int wordId) {
		ComFunExample comFunExample = new ComFunExample();
		ComFunExample.Criteria criteria = comFunExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.comFunMapper.deleteByExample(comFunExample);
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	public Map<? extends String, ? extends Object> saveSystemAnalService(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.putAll(this.saveNinescreen(wordId));
		dataMap.putAll(this.saveLife(wordId, imgMap));
		dataMap.putAll(this.saveSource(wordId));
		dataMap.putAll(this.saveFunction(wordId, imgMap));
		
		return dataMap;
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveFunction(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Function> funs = this.findFunction(wordId);
    	if(funs.size() > 0) {
			Function fun = funs.get(0);
			List<ComFun> comfuns = this.finComFun(wordId);
        	String comStr = fun.getComponent();
        	String[] com = comStr.split("，");
     //   	String funImgPath = Path.getRealPath() + "/images/word" + wordId + "/funImg.png";
        	int funTable1Row = com.length + 1;
        	
        	List<List<String>> com1 = this.saveFunTable1Content(comfuns, com);   
        	List<String> lengthList = this.saveFunTable1Length(funTable1Row);
        	List<Map<String,Object>> com2List = this.saveFunTable2(comfuns);
        	
        	dataMap.putAll(this.saveFunDesc(fun));
        	dataMap.put("com1length", lengthList);
        	dataMap.put("com1out", com1);
    		dataMap.put("com2out", com2List); 
  //  		dataMap.put("funImg", ImgStr.getImgStr(funImgPath));  
    		dataMap.put("funImg", imgMap.get("funImg"));  
		} else {
			dataMap.put("fun_system", "");
        	dataMap.put("fun_function", "");
        	dataMap.put("fun_component", "");
        	List<List<String>> com1 = new ArrayList<List<String>>();
    		List<String> arry = new ArrayList<String>();
    		arry.add(" ");
    		com1.add(arry);    	     	
    		int length = 1;
    		List<String> lengthList = this.saveFunTable1Length(length);
        	dataMap.put("com1length", lengthList);
        	List<Map<String,Object>> com2List = new ArrayList<Map<String,Object>>(); 
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("id", "");
			map.put("precom", "");
			map.put("fun", "");
			map.put("lastcom", "");
			map.put("para", "");
			map.put("type", "");
			map.put("level", "");    			
            com2List.add(map); 
        	dataMap.put("com1out", com1);
    		dataMap.put("com2out", com2List); 
    		dataMap.put("funImg", "");     
		}
		return dataMap;
	}
	
	private Map<? extends String, ? extends Object> saveFunDesc(Function fun) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap .put("fun_system", fun.getSystem());
    	dataMap.put("fun_function", fun.getFunction());
    	dataMap.put("fun_component", fun.getComponent());
    	return dataMap;
	}
	
	private List<Map<String, Object>> saveFunTable2(List<ComFun> comfuns) {
		
    	List<Map<String,Object>> com2List = new ArrayList<Map<String,Object>>(); 
    	String[] para = new String[]{"有益","有害"};
    	String[] level = new String[]{"适当","不足","过度"};
		for(int i=0;i<comfuns.size();i++) {
			ComFun cf = comfuns.get(i);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("id", i+1);
			map.put("precom", cf.getPrename());
			map.put("fun", cf.getFunction());
			map.put("lastcom", cf.getAftername());
			map.put("para", cf.getPara());
			map.put("type", para[cf.getType()-1]);
			map.put("level", level[cf.getLevel()-1]);	
            com2List.add(map); 
		}
		return com2List;
	}
	
	private List<String> saveFunTable1Length(int funTable1Row) {    	     	
		int total = 9854;
		List<String> lengthList = new ArrayList<String>();
		lengthList.add(((int)(total - Math.floor(total/funTable1Row)*(funTable1Row-1))) + "");
		for(int i=0;i<funTable1Row-1;i++) {
			lengthList.add((int)Math.floor(total/funTable1Row) + "");
		}	
    	return lengthList;
	}
	
	private List<List<String>> saveFunTable1Content(List<ComFun> comfuns, String[] com) {
		List<List<String>> com1 = new ArrayList<List<String>>();
		for(int i=0;i<=com.length;i++) {
    		List<String> arry = new ArrayList<String>();
    		for(int j=0;j<=com.length;j++) {
    			if(i == 0) {
    				arry.add(j==0?"":com[j-1]);
    			} else {
    				if(j == 0) {
    					arry.add(com[i-1]);
    				} else {
    					arry.add(" ");
    				}
    			}
    		}
    		com1.add(arry);
    	}
		for(int i=0;i<comfuns.size();i++) {
			int y = 0;
			int x = 0;
			ComFun cf = comfuns.get(i);
			for(int j=0;j<com.length;j++) {
				if(cf.getPrename().equals(com[j])) {
					x = j;
				}
				if(cf.getAftername().equals(com[j])) {
					y = j;
				}
			}
			if(x != y) {
				com1.get(x+1).set(y+1, "+");
			}
		}
		return com1;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveSource(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Source> sources = this.findSource(wordId);
    	List<Map<String,Object>> resourceList = new ArrayList<Map<String,Object>>(); 
    	String[][] table1 = new String[3][6];
    	String[] table2 = new String[12];
    	for(int m=0;m<table1.length;m++) {
			for(int n=0;n<table1[m].length;n++) {
				table1[m][n] = ""; 
			}
		}
		for(int m=0;m<table2.length;m++) {
			table2[m] = ""; 
		}
    	String[] txt = {"免费","廉价","昂贵","无限","足够","不足","有益","中性","有害","成品","改变可用","需要建造"};
    	if(sources.size() > 0) {
			for(int i=0;i<sources.size();i++) {
				Source source = sources.get(i);
				int value = Integer.parseInt(source.getValue());
				int quantity = Integer.parseInt(source.getQuantity());
				int quality = Integer.parseInt(source.getQuality());
				int usable = Integer.parseInt(source.getUsable());
				int sys = Integer.parseInt(source.getSystem());
				int type = Integer.parseInt(source.getType());
				table1[sys-1][type-1] += (source.getName() + ",");
				table2[value-1] += (source.getName() + ",");
				table2[quantity+2] += (source.getName() + ",");
				table2[quality+5] += (source.getName() + ",");
				table2[usable+8] += (source.getName() + ",");
				for(int m=0;m<table1.length;m++) {
					for(int n=0;n<table1[m].length;n++) {
						dataMap.put("table"+(m+1)+(n+1), table1[m][n]); 
					}
				}
				for(int m=0;m<table2.length;m++) {
					dataMap.put("table4"+(m+1), table2[m]); 
				}
				Map<String,Object> map = new HashMap<String,Object>();  
				map.put("name", source.getName());
				map.put("value", txt[value-1]);
				map.put("quantity", txt[value+2]);
				map.put("quality", txt[value+5]);
				map.put("usable", txt[value+8]);
				resourceList.add(map);  
                dataMap.put("res", resourceList); 
			}
		} else {
			for(int m=0;m<table1.length;m++) {
				for(int n=0;n<table1[m].length;n++) {
					dataMap.put("table"+(m+1)+(n+1), ""); 
				}
			}
			for(int m=0;m<table2.length;m++) {
				dataMap.put("table4"+(m+1), ""); 
			}
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("name", "");
			map.put("value", "");
			map.put("quantity", "");
			map.put("quality", "");
			map.put("usable", "");
			resourceList.add(map);  
            dataMap.put("res", resourceList); 
		}
		return dataMap;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveLife(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
	//	String lifeImgPath = Path.getRealPath() + "/images/lifeImg.png";
	//	dataMap.put("lifeImg", ImgStr.getImgStr(lifeImgPath));
		dataMap.put("lifeImg", imgMap.get("lifeImg"));
		return dataMap;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveNinescreen(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Ninescreen> nss = this.getNineScreens(wordId);
    	String[] screen = new String[9];
    	for(int i=0;i<nss.size();i++) {
    		Ninescreen ns = nss.get(i);
    		int index = Integer.parseInt(ns.getName().substring(6));
    		screen[index-1] = ns.getTxt();
    	}
    	for(int i=0;i<screen.length;i++) {
    		dataMap.put("screen"+(i+1), screen[i]);
    	}
		return dataMap;
	}

}
