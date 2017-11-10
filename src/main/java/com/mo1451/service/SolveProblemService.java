/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.IdealResMapper;
import com.mo1451.mapper.ObjFieldMapper;
import com.mo1451.mapper.PhysicalMapper;
import com.mo1451.mapper.PrincipleMapper;
import com.mo1451.mapper.TechMapper;
import com.mo1451.model.IdealRes;
import com.mo1451.model.IdealResExample;
import com.mo1451.model.ObjFieldExample;
import com.mo1451.model.ObjFieldWithBLOBs;
import com.mo1451.model.Physical;
import com.mo1451.model.PhysicalExample;
import com.mo1451.model.Principle;
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
		// TODO Auto-generated method stub
		String str = this.principleMapper.selectMatrixByPara(t);
//		System.out.println(str);
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
		// TODO Auto-generated method stub
		String[] str1 = ofwbs.getNode1() != null ? ofwbs.getNode1().split(",") : new String[]{"s1","s2","f"};
		String[] str2 = ofwbs.getNode2() != null ? ofwbs.getNode2().split(",") : new String[]{"s1","s2","f","s3"};
		String[] str3 = ofwbs.getNode3() != null ? ofwbs.getNode3().split(",") : new String[]{"s1","s2","f","f2"};
		String[] str4 = ofwbs.getNode4() != null ? ofwbs.getNode4().split(",") : new String[]{"s1","s2","f1","f2","f3"};
		String[][] str = {str1,str2,str3,str4};
		return str;
	}
}
