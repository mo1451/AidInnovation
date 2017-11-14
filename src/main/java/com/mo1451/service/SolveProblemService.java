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

import com.mo1451.mapper.IdealResMapper;
import com.mo1451.mapper.ObjFieldMapper;
import com.mo1451.mapper.PhysicalMapper;
import com.mo1451.mapper.PrincipleMapper;
import com.mo1451.mapper.StcOperatorMapper;
import com.mo1451.mapper.TechMapper;
import com.mo1451.model.IdealRes;
import com.mo1451.model.IdealResExample;
import com.mo1451.model.ObjFieldExample;
import com.mo1451.model.ObjFieldWithBLOBs;
import com.mo1451.model.Physical;
import com.mo1451.model.PhysicalExample;
import com.mo1451.model.Principle;
import com.mo1451.model.StcOperator;
import com.mo1451.model.StcOperatorExample;
import com.mo1451.model.Tech;
import com.mo1451.model.TechExample;

/**
 * @author 默1451
 *
 */
@Service
public class SolveProblemService {
	private IdealResMapper idealResMapper;
	private TechMapper techMapper;
	private PrincipleMapper principleMapper;
	private PhysicalMapper physicalMapper;
	private ObjFieldMapper objFieldMapper;
	private StcOperatorMapper stcOperatorMapper;
	
	public IdealResMapper getIdealResMapper() {
		return idealResMapper;
	}

	@Resource(name="idealResMapper")
	public void setIdealResMapper(IdealResMapper idealResMapper) {
		this.idealResMapper = idealResMapper;
	}

	/**
	 * 添加或更新理想解
	 * @param aim
	 * @param result
	 * @param obstacle
	 * @param obsResult
	 * @param condition
	 * @param resource
	 */
	public void addOrUpdateIdealRes(String aim, String result, String obstacle, String obsResult, String condition,
			String resource,int wordId) {
		IdealResExample idealResExample = new IdealResExample();
		IdealResExample.Criteria criteria = idealResExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<IdealRes> irs = this.idealResMapper.selectByExample(idealResExample);
		if(irs.size() > 0) {
			IdealRes ir = irs.get(0);
			ir.setAim(aim);
			ir.setCond(condition);
			ir.setObsRes(obsResult);
			ir.setObstacle(obstacle);
			ir.setResource(resource);
			ir.setResult(result);
			this.idealResMapper.updateByPrimaryKeySelective(ir);
		} else {
			IdealRes ir = new IdealRes();
			ir.setAim(aim);
			ir.setCond(condition);
			ir.setObsRes(obsResult);
			ir.setObstacle(obstacle);
			ir.setResource(resource);
			ir.setResult(result);
			ir.setWordid(wordId);
			this.idealResMapper.insertSelective(ir);
		}
	}

	/**
	 * 找到IdealRes
	 * @param wordId
	 * @return
	 */
	public List<IdealRes> findIdealRes(int wordId) {
		IdealResExample idealResExample = new IdealResExample();
		IdealResExample.Criteria criteria = idealResExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.idealResMapper.selectByExample(idealResExample);
	}

	/**
	 * 添加或修改技术矛盾
	 * @param a1
	 * @param a2
	 * @param b1
	 * @param b2
	 * @param c1
	 * @param c2
	 * @param tech_con
	 * @param com1
	 * @param com2
	 * @param com3
	 * @param improve
	 * @param worse
	 * @param wordId
	 */
	public void addOrUpdateTech(String a1, String a2, String b1, String b2, String c1, String c2, String tech_con,
			String com1, String com2, String com3, String improve, String worse, int wordId) {
		TechExample techExample = new TechExample();
		TechExample.Criteria criteria = techExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Tech> techs = this.techMapper.selectByExample(techExample);
		if(techs.size() > 0) {
			Tech tech = techs.get(0);
			tech.setA1(a1);
			tech.setA2(a2);
			tech.setB1(b1);
			tech.setB2(b2);
			tech.setC1(c1);
			tech.setC2(c2);
			tech.setCom1(com1);
			tech.setCom2(com2);
			tech.setCom3(com3);
			tech.setTechCon((tech_con != null && !tech_con.equals("")) ? Integer.parseInt(tech_con) : null);
			tech.setImprove((improve != null && !improve.equals("")) ? Integer.parseInt(improve) : null);
			tech.setWorse((worse != null && !worse.equals("")) ? Integer.parseInt(worse) : null);
			this.techMapper.updateByPrimaryKeySelective(tech);
		} else {
			Tech tech = new Tech();
			tech.setA1(a1);
			tech.setA2(a2);
			tech.setB1(b1);
			tech.setB2(b2);
			tech.setC1(c1);
			tech.setC2(c2);
			tech.setCom1(com1);
			tech.setCom2(com2);
			tech.setCom3(com3);
			tech.setTechCon((tech_con != null && !tech_con.equals("")) ? Integer.parseInt(tech_con) : null);
			tech.setImprove((improve != null && !improve.equals("")) ? Integer.parseInt(improve) : null);
			tech.setWorse((worse != null && !worse.equals("")) ? Integer.parseInt(worse) : null);
			tech.setWordid(wordId);
			this.techMapper.insertSelective(tech);
		}
	}

	/**
	 * 找到技术矛盾
	 * @param wordId
	 * @return
	 */
	public List<Tech> findtech(int wordId) {
		TechExample techExample = new TechExample();
		TechExample.Criteria criteria = techExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.techMapper.selectByExample(techExample);
	}

	public TechMapper getTechMapper() {
		return techMapper;
	}

	@Resource(name="techMapper")
	public void setTechMapper(TechMapper techMapper) {
		this.techMapper = techMapper;
	}

	public PrincipleMapper getPrincipleMapper() {
		return principleMapper;
	}

	@Resource(name="principleMapper")
	public void setPrincipleMapper(PrincipleMapper principleMapper) {
		this.principleMapper = principleMapper;
	}

	/**
	 * 通过阿奇舒勒矛盾矩阵得到发明原理
	 * @param improve
	 * @param worse
	 * @return
	 */
	public List<Principle> getMatrixPrinciple(Tech t) {
		String str = this.principleMapper.selectMatrixByPara(t);
		if(str!=null) {
			String[] split = str.split(",");
			int[] prinId = new int[split.length];
			for(int i=0;i<split.length;i++) {
				prinId[i] = Integer.parseInt(split[i]);
			}
			List<Principle> prins = this.principleMapper.selectByIds(prinId);
			return prins;
		} else {
			return null;
		}
		
	}

	public PhysicalMapper getPhysicalMapper() {
		return physicalMapper;
	}

	@Resource(name="physicalMapper")
	public void setPhysicalMapper(PhysicalMapper physicalMapper) {
		this.physicalMapper = physicalMapper;
	}

	/**
	 * 添加或修改物理矛盾
	 * @param word11
	 * @param word12
	 * @param word13
	 * @param word21
	 * @param word22
	 * @param word23
	 * @param space
	 * @param time
	 * @param cond
	 * @param whole
	 */
	public void addOrUpdatePhysical(String word11, String word12, String word13, String word21, String word22,
			String word23, String space, String time, String cond, String whole,int wordId) {
		PhysicalExample phyExample = new PhysicalExample();
		PhysicalExample.Criteria criteria = phyExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Physical> phys = this.physicalMapper.selectByExample(phyExample);
		if(phys.size() > 0) {
			Physical phy = phys.get(0);
			phy.setTxt1(word11);
			phy.setTxt2(word12);
			phy.setTxt3(word13);
			phy.setTxt4(word21);
			phy.setTxt5(word22);
			phy.setTxt6(word23);
			phy.setSpace(space);
			phy.setTim(time);
			phy.setCond(cond);
			phy.setWhole(whole);
			this.physicalMapper.updateByPrimaryKeySelective(phy);
		} else {
			Physical phy = new Physical();
			phy.setTxt1(word11);
			phy.setTxt2(word12);
			phy.setTxt3(word13);
			phy.setTxt4(word21);
			phy.setTxt5(word22);
			phy.setTxt6(word23);
			phy.setSpace(space);
			phy.setTim(time);
			phy.setCond(cond);
			phy.setWhole(whole);
			phy.setWordid(wordId);
			this.physicalMapper.insertSelective(phy);
		}
		
	}

	/**
	 * 找到物理矛盾
	 * @param wordId
	 * @return
	 */
	public List<com.mo1451.model.Physical> findPhy(int wordId) {
		PhysicalExample phyExample = new PhysicalExample();
		PhysicalExample.Criteria criteria = phyExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.physicalMapper.selectByExample(phyExample);
	}

	/**
	 * 添加或更新物场模型1
	 * @param txt
	 * @param explain1
	 * @param wordId
	 * @param node2 
	 * @param node1 
	 */
	public void addOrUpdateObject(String txt, String explain1, int wordId, String[] node1, String[] node2) {
		ObjFieldExample objFieldExample = new ObjFieldExample();
		ObjFieldExample.Criteria criteria = objFieldExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		String str1 = "";
		String str2 = "";
		if(node1 != null) {
			for(int i=0;i<node1.length;i++) {
				str1 += node1[i];
				if(i < node1.length-1) {
					str1 += ",";
				}
			}
		}
		if(node2 != null) {
			for(int i=0;i<node2.length;i++) {
				str2 += node2[i];
				if(i < node2.length-1) {
					str2 += ",";
				}
			}
		}
		List<ObjFieldWithBLOBs> ofs = this.objFieldMapper.selectByExampleWithBLOBs(objFieldExample);
		if(ofs.size() > 0) {
			ObjFieldWithBLOBs ofwbs = ofs.get(0);
			ofwbs.setExplain1(explain1);
			ofwbs.setType(1);
			ofwbs.setTxt(txt);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			this.objFieldMapper.updateByPrimaryKeySelective(ofwbs);
		} else {
			ObjFieldWithBLOBs ofwbs = new ObjFieldWithBLOBs();
			ofwbs.setExplain1(explain1);
			ofwbs.setTxt(txt);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			ofwbs.setType(1);
			ofwbs.setWordid(wordId);
			this.objFieldMapper.insertSelective(ofwbs);
		}
	}

	public ObjFieldMapper getObjFieldMapper() {
		return objFieldMapper;
	}

	@Resource(name="objFieldMapper")
	public void setObjFieldMapper(ObjFieldMapper objFieldMapper) {
		this.objFieldMapper = objFieldMapper;
	}

	/**
	 * 获取物场数据
	 * @param wordId
	 * @return
	 */
	public List<ObjFieldWithBLOBs> findObjectField(int wordId) {
		ObjFieldExample objFieldExample = new ObjFieldExample();
		ObjFieldExample.Criteria criteria = objFieldExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		return this.objFieldMapper.selectByExampleWithBLOBs(objFieldExample);
	}

	/**
	 * 添加或更新物场模型2
	 * @param txt
	 * @param explain1
	 * @param explain2
	 * @param node3 
	 * @param node2 
	 * @param node1 
	 * @param wordId
	 */
	public void addOrUpdateObject(String txt, String explain1, String explain2, String[] node1, String[] node2, String[] node3, int wordId) {
		ObjFieldExample objFieldExample = new ObjFieldExample();
		ObjFieldExample.Criteria criteria = objFieldExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ObjFieldWithBLOBs> ofs = this.objFieldMapper.selectByExampleWithBLOBs(objFieldExample);
		String str1 = "";
		String str2 = "";
		String str3 = "";
		if(node1 != null) {
			for(int i=0;i<node1.length;i++) {
				str1 += node1[i];
				if(i < node1.length-1) {
					str1 += ",";
				}
			}
		}
		if(node2 != null) {
			for(int i=0;i<node2.length;i++) {
				str2 += node2[i];
				if(i < node2.length-1) {
					str2 += ",";
				}
			}
		}
		if(node3 != null) {
			for(int i=0;i<node3.length;i++) {
				str3 += node3[i];
				if(i < node3.length-1) {
					str3 += ",";
				}
			}
		}
		if(ofs.size() > 0) {
			ObjFieldWithBLOBs ofwbs = ofs.get(0);
			ofwbs.setExplain1(explain1);
			ofwbs.setExplain2(explain2);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			ofwbs.setNode3(str3);
			ofwbs.setType(2);
			ofwbs.setTxt(txt);
			this.objFieldMapper.updateByPrimaryKeySelective(ofwbs);
		} else {
			ObjFieldWithBLOBs ofwbs = new ObjFieldWithBLOBs();
			ofwbs.setExplain1(explain1);
			ofwbs.setExplain2(explain2);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			ofwbs.setNode3(str3);
			ofwbs.setTxt(txt);
			ofwbs.setType(2);
			ofwbs.setWordid(wordId);
			this.objFieldMapper.insertSelective(ofwbs);
		}
	}

	/**
	 * 添加或更新物场模型3
	 * @param txt
	 * @param explain1
	 * @param explain2
	 * @param explain3
	 * @param node4 
	 * @param node3 
	 * @param node2 
	 * @param node1 
	 * @param wordId
	 */
	public void addOrUpdateObject(String txt, String explain1, String explain2, String explain3, String[] node1, String[] node2, String[] node3, String[] node4, int wordId) {
		ObjFieldExample objFieldExample = new ObjFieldExample();
		ObjFieldExample.Criteria criteria = objFieldExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<ObjFieldWithBLOBs> ofs = this.objFieldMapper.selectByExampleWithBLOBs(objFieldExample);
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		if(node1 != null) {
			for(int i=0;i<node1.length;i++) {
				str1 += node1[i];
				if(i < node1.length-1) {
					str1 += ",";
				}
			}
		}
		if(node2 != null) {
			for(int i=0;i<node2.length;i++) {
				str2 += node2[i];
				if(i < node2.length-1) {
					str2 += ",";
				}
			}
		}
		if(node3 != null) {
			for(int i=0;i<node3.length;i++) {
				str3 += node3[i];
				if(i < node3.length-1) {
					str3 += ",";
				}
			}
		}
		if(node4 != null) {
			for(int i=0;i<node4.length;i++) {
				str4 += node4[i];
				if(i < node4.length-1) {
					str4 += ",";
				}
			}
		}
		if(ofs.size() > 0) {
			ObjFieldWithBLOBs ofwbs = ofs.get(0);
			ofwbs.setExplain1(explain1);
			ofwbs.setExplain2(explain2);
			ofwbs.setExplain3(explain3);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			ofwbs.setNode3(str3);
			ofwbs.setNode4(str4);
			ofwbs.setType(3);
			ofwbs.setTxt(txt);
			this.objFieldMapper.updateByPrimaryKeySelective(ofwbs);
		} else {
			ObjFieldWithBLOBs ofwbs = new ObjFieldWithBLOBs();
			ofwbs.setExplain1(explain1);
			ofwbs.setExplain2(explain2);
			ofwbs.setExplain3(explain3);
			ofwbs.setNode1(str1);
			ofwbs.setNode2(str2);
			ofwbs.setNode3(str3);
			ofwbs.setNode4(str4);
			ofwbs.setTxt(txt);
			ofwbs.setType(3);
			ofwbs.setWordid(wordId);
			this.objFieldMapper.insertSelective(ofwbs);
		}
	}

	/**
	 * @param objFieldWithBLOBs
	 * @return
	 */
	public String[][] getNodes(ObjFieldWithBLOBs ofwbs) {
		String[] str1 = ofwbs.getNode1() != null ? ofwbs.getNode1().split(",") : new String[]{"s1","s2","f"};
		String[] str2 = ofwbs.getNode2() != null ? ofwbs.getNode2().split(",") : new String[]{"s1","s2","f","s3"};
		String[] str3 = ofwbs.getNode3() != null ? ofwbs.getNode3().split(",") : new String[]{"s1","s2","f","f2"};
		String[] str4 = ofwbs.getNode4() != null ? ofwbs.getNode4().split(",") : new String[]{"s1","s2","f1","f2","f3"};
		String[][] str = {str1,str2,str3,str4};
		return str;
	}

	/**
	 * @param wordId
	 */
	public void deleteAll(int wordId) {
		this.deleteIdealRes(wordId);
		this.deleteObjectField(wordId);
		this.deletePhysical(wordId);
		this.deleteTech(wordId);
	}

	/**
	 * @param wordId
	 */
	private void deleteTech(int wordId) {
		TechExample techExample = new TechExample();
		TechExample.Criteria criteria = techExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.techMapper.deleteByExample(techExample);
	}

	/**
	 * @param wordId
	 */
	private void deletePhysical(int wordId) {
		PhysicalExample physicalExample = new PhysicalExample();
		PhysicalExample.Criteria criteria = physicalExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.physicalMapper.deleteByExample(physicalExample);
	}

	/**
	 * @param wordId
	 */
	private void deleteObjectField(int wordId) {
		ObjFieldExample objFieldExample = new ObjFieldExample();
		ObjFieldExample.Criteria criteria = objFieldExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.objFieldMapper.deleteByExample(objFieldExample);
	}

	/**
	 * @param wordId
	 */
	private void deleteIdealRes(int wordId) {
		IdealResExample idealResExample = new IdealResExample();
		IdealResExample.Criteria criteria = idealResExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		this.idealResMapper.deleteByExample(idealResExample);
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	public Map<? extends String, ? extends Object> saveSolveProblem(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.putAll(this.saveIdealResult(wordId));
		dataMap.putAll(this.saveTechnology(wordId));
		dataMap.putAll(this.savePhysical(wordId));
		dataMap.putAll(this.saveObjectField(wordId, imgMap));
		return dataMap;
	}

	/**
	 * @param wordId
	 * @param imgMap 
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveObjectField(int wordId, Map<String, String> imgMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ObjFieldWithBLOBs> ofs = this.findObjectField(wordId);
		String[] name = new String[]{"不完整模型","有害效应的完整模型","效应不足的完整模型"};
		String[] desc = new String[]{"是第一类模型，不完整模型，有一个一般解法","是第二类模型，有害效应的完整模型，有两个一般解法","是第三类模型，效应不足的完整模型，有三个一般解法"};
		String[][] ofDesc = new String[][]{{"一般解法1：补齐所缺失的元素，增加场F或工具S2，完整模型。"},{"一般解法2：加入第3种物质S3，S3用来阻止有害作用。S3可以是通过S1或S2改变而来，或者是S1/S2共同改变而来。","一般解法3：增加另外一个场F2来抵消原来有害场F的效应。"},{"一般解法4：用另一个场F2（或者F2和S3一起）代替原来的场F1（或者F1和S2一起）。","一般解法5：增加另外一个场F2来强化有用的效应。","一般解法6：插进一个物质S3并加上另一个场F2来提高有用效应。"}};
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
		if(ofs.size() > 0) {
			ObjFieldWithBLOBs of = ofs.get(0);
			dataMap.put("name", name[of.getType()-1]);
			dataMap.put("text", of.getTxt());
			dataMap.put("desc", desc[of.getType()-1]);
	//		String ObjectImg0Path = Path.getRealPath() + "/images/word" + wordId + "/objectImg0.png";
	//		dataMap.put("model0Img", ImgStr.getImgStr(ObjectImg0Path));
			dataMap.put("model0Img", imgMap.get("objectImg0"));
			for(int i=0;i<of.getType();i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("desc", ofDesc[of.getType()-1][i]);
	//			String ObjectImgPath = Path.getRealPath() + "/images/word" + wordId + "/objectImg" + (i+1) + ".png";
	//			map.put("modelImg", ImgStr.getImgStr(ObjectImgPath));
//				String str = "objectImg" + (i+1);
//				String str2 = imgMap.get(str);
				map.put("modelImg", imgMap.get("objectImg" + (i+1)));
				switch(i+1) {
				case 1: map.put("txt", of.getExplain1());
				break;
				case 2:map.put("txt", of.getExplain2());
				break;
				case 3:map.put("txt", of.getExplain3());
				break;
				}
				list.add(map);
			}
		} else {
			dataMap.put("name", "");
			dataMap.put("text", "");
			dataMap.put("desc", "");
			dataMap.put("model0Img", "");
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("desc", "");
			map.put("modelImg", "");
			map.put("txt", "");
			list.add(map);
		}
		dataMap.put("modelList", list);
		return dataMap;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> savePhysical(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Physical> phys = this.findPhy(wordId);
		if(phys.size() > 0) {
			Physical phy = phys.get(0);
			dataMap.put("text1", phy.getTxt1());
			dataMap.put("text2", phy.getTxt2());
			dataMap.put("text3", phy.getTxt3());
			dataMap.put("text4", phy.getTxt4());
			dataMap.put("text5", phy.getTxt5());
			dataMap.put("text6", phy.getTxt6());
			dataMap.put("space", phy.getSpace());
			dataMap.put("time", phy.getTim());
			dataMap.put("phy_condition", phy.getCond());
			dataMap.put("part", phy.getWhole());
		} else {
			dataMap.put("text1", "");
			dataMap.put("text2", "");
			dataMap.put("text3", "");
			dataMap.put("text4", "");
			dataMap.put("text5", "");
			dataMap.put("text6", "");
			dataMap.put("space", "");
			dataMap.put("time", "");
			dataMap.put("phy_condition", "");
			dataMap.put("part", "");
		}
		return dataMap;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveTechnology(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Tech> tech = this.findtech(wordId);
		String[] aqslPara = {"1、运动物体的重量","2、静止物体的重量","3、运动物体的长度","4、静止物体的长度","5、运动物体的面积","6、静止物体的面积","7、运动物体的体积","8、静止物体的体积","9、速度","10、力","11、应力或压力","12、形状","13、结构的稳定性","14、强度","15、运动物体作用时间","16、静止物体作用时间","17、温度","18、光照度","19、运动物体的能量","20、静止物体的能量","21、功率","22、能量损失","23、物质损失","24、信息损失","25、时间损失","26、物质或事物的数量","27、可靠性","28、测试精度","29、制造精度","30、物体外部有害因素作用的敏感性","31、物体产生的有害因素因素","32、可制造性","33、可操作性","34、可维修性","35、适应性及多用性","36、装置的复杂性","37、监控与测试的困难程度","38、自动化程度","39、生产率"};
		if(tech.size()>0) {
			Tech t = tech.get(0);
			dataMap.put("A1", t.getA1());
			dataMap.put("A2", t.getA2());
			dataMap.put("B1", t.getB1());
			dataMap.put("B2", t.getB2());
			dataMap.put("C1", t.getC1());
			dataMap.put("C2", t.getC2());
			dataMap.put("tech_con", ("EC-" + t.getTechCon()));
			dataMap.put("com1", t.getCom1());
			dataMap.put("com2", t.getCom2());
			dataMap.put("com3", t.getCom3());
			dataMap.put("improve", aqslPara[t.getImprove()-1]);
			dataMap.put("worse", aqslPara[t.getWorse()-1]);
			List<Principle> prins = this.getMatrixPrinciple(t);
			String prinStr = "";
			for(int i=0;i<prins.size();i++) {
				prinStr += prins.get(i).getId() + "、" + prins.get(i).getName();
			}
			dataMap.put("principles", prinStr);
		} else {
			dataMap.put("A1", "");
			dataMap.put("A2", "");
			dataMap.put("B1", "");
			dataMap.put("B2", "");
			dataMap.put("C1", "");
			dataMap.put("C2", "");
			dataMap.put("tech_con", ("EC-" + ""));
			dataMap.put("com1", "");
			dataMap.put("com2", "");
			dataMap.put("com3", "");
			dataMap.put("improve", "");
			dataMap.put("worse", "");		
			dataMap.put("principles", "");
		}
		return dataMap;
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Map<? extends String, ? extends Object> saveIdealResult(int wordId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<IdealRes> irs = this.findIdealRes(wordId);
		if(irs.size()>0) {
			IdealRes ir = irs.get(0);
			dataMap.put("aim", ir.getAim());
			dataMap.put("result", ir.getResult());
			dataMap.put("obstacle", ir.getObstacle());
			dataMap.put("obs_res", ir.getObsRes());
			dataMap.put("condition", ir.getCond());
			dataMap.put("resource", ir.getResource());
		} else {
			dataMap.put("aim", "");
			dataMap.put("result", "");
			dataMap.put("obstacle", "");
			dataMap.put("obs_res", "");
			dataMap.put("condition", "");
			dataMap.put("resource", "");	
		}
		return dataMap;
	}

	public StcOperatorMapper getStcOperatorMapper() {
		return stcOperatorMapper;
	}

	@Resource
	public void setStcOperatorMapper(StcOperatorMapper stcOperatorMapper) {
		this.stcOperatorMapper = stcOperatorMapper;
	}

	/**
	 * @param bigString
	 * @param smallString
	 * @param longTimeString
	 * @param shortTimeString
	 * @param expensiveString
	 * @param chipString
	 * @param wordId
	 */
	public void addOrUpdateStcOperator(String bigString, String smallString, String longTimeString,
			String shortTimeString, String expensiveString, String chipString, int wordId) {
		List<StcOperator> stcOperators = this.findStcOperator(wordId);
		if(stcOperators.size() > 0) {
			StcOperator stcOperator = stcOperators.get(0);
			stcOperator.setBig(bigString);
			stcOperator.setChip(chipString);
			stcOperator.setExpensive(expensiveString);
			stcOperator.setLongTime(longTimeString);
			stcOperator.setSmall(smallString);
			stcOperator.setShortTime(shortTimeString);
			stcOperator.setWordid(wordId);
			stcOperatorMapper.updateByPrimaryKeySelective(stcOperator);
		} else {
			StcOperator stcOperator = new StcOperator();
			stcOperator.setWordid(wordId);
			stcOperatorMapper.insertSelective(stcOperator);
		}
		
	}

	/**
	 * @param wordId
	 * @return
	 */
	public List<StcOperator> findStcOperator(int wordId) {
		StcOperatorExample stcOperatorExample = new StcOperatorExample();
		StcOperatorExample.Criteria criteria = stcOperatorExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<StcOperator> stcOperators = this.stcOperatorMapper.selectByExample(stcOperatorExample);
		return stcOperators;
	}
	
	
}
