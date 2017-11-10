/**
 * 
 */
package com.mo1451.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mo1451.mapper.ProblemDescrMapper;
import com.mo1451.model.ComFun;
import com.mo1451.model.Function;
import com.mo1451.model.IdealRes;
import com.mo1451.model.Ninescreen;
import com.mo1451.model.ObjFieldWithBLOBs;
import com.mo1451.model.Physical;
import com.mo1451.model.Principle;
import com.mo1451.model.ProblemDescrWithBLOBs;
import com.mo1451.model.Source;
import com.mo1451.model.Tech;
import com.mo1451.model.WordWithBLOBs;
import com.mo1451.service.ArrangeAndEvaluateService;
import com.mo1451.service.ProblemDescrService;
import com.mo1451.service.SolveProblemService;
import com.mo1451.service.SystemAnalService;
import com.mo1451.service.WordService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import junit.framework.TestCase;
import sun.misc.BASE64Encoder;

/**
 * @author 默1451
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class CreateWordTest extends TestCase {
	private ProblemDescrMapper problemDescrMapper;
	private Configuration configuration = null;
	private ProblemDescrService problemDescrService;
	
	
	
	@Test
	public void TestProblemDesc() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		problemDescrService = (ProblemDescrService) context.getBean("problemDescrService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	ProblemDescrWithBLOBs pdwb = problemDescrService.checkWordId(38);
			if(pdwb != null) {
				dataMap.put("source", pdwb.getSource());
				dataMap.put("descr", pdwb.getDescr());
				dataMap.put("function", pdwb.getFun());
				dataMap.put("component", pdwb.getComponent());
				dataMap.put("principle", pdwb.getPrinciple());
				dataMap.put("problem", pdwb.getProblem());
				dataMap.put("parameter", pdwb.getParameter());
				dataMap.put("goal", pdwb.getGoal());
				dataMap.put("limit", pdwb.getLim());
				dataMap.put("exist", pdwb.getExist());
			} else {
				dataMap.put("source", "");
				dataMap.put("descr", "");
				dataMap.put("function", "");
				dataMap.put("component", "");
				dataMap.put("principle", "");
				dataMap.put("problem", "");
				dataMap.put("parameter", "");
				dataMap.put("goal", "");
				dataMap.put("limit", "");
				dataMap.put("exist", "");
			}
                configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
                Template template = configuration.getTemplate("problemdescr.ftl");

                File outFile = new File("F:/temp/problemdescr"+ "" +".doc");
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
                template.process(dataMap, out);
                out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void TestCausal() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		WordService wordService = (WordService) context.getBean("wordService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	WordWithBLOBs wwbs = wordService.findWord(38);
        	if(wwbs != null) {
        		dataMap.put("causalsol", wwbs.getCausalsol());
				dataMap.put("img", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/cau_img38.png"));
        	}
            configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("causal.ftl");

            File outFile = new File("F:/temp/causal"+ "" +".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void TestSysAnl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		WordService wordService = (WordService) context.getBean("wordService");
		SystemAnalService systemAnalService = (SystemAnalService) context.getBean("systemAnalService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	WordWithBLOBs wwbs = wordService.findWord(38);
        	if(wwbs != null) {
        		dataMap.put("ninesol", wwbs.getNinesol());
        		dataMap.put("lifesol", wwbs.getLifesol());
        		dataMap.put("resourcesol", wwbs.getResourcesol());
        	}
        	List<Ninescreen> nss = systemAnalService.getNineScreens(38);
        	String[] screen = new String[9];
        	for(int i=0;i<nss.size();i++) {
        		Ninescreen ns = nss.get(i);
        		int index = Integer.parseInt(ns.getName().substring(6));
        		screen[index-1] = ns.getTxt();
        	}
        	for(int i=0;i<screen.length;i++) {
        		dataMap.put("screen"+(i+1), screen[i]);
        	}
        	dataMap.put("lifeImg", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/lifeImg.png"));
        	List<Source> sources = systemAnalService.findSource(38);
        	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
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
    					dataMap.put("table3"+(m+1), table2[m]); 
    				}
    				Map<String,Object> map = new HashMap<String,Object>();  
    				map.put("name", source.getName());
    				map.put("value", txt[value-1]);
    				map.put("quantity", txt[value+2]);
    				map.put("quality", txt[value+5]);
    				map.put("usable", txt[value+8]);
                    list.add(map);  
	                dataMap.put("res", list); 
    			}
    		}
        	
        	
        	
            configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("sysanl.ftl");

            File outFile = new File("F:/temp/sysanl"+ "" +".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void TestFun() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		WordService wordService = (WordService) context.getBean("wordService");
		SystemAnalService systemAnalService = (SystemAnalService) context.getBean("systemAnalService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	WordWithBLOBs wwbs = wordService.findWord(38);
        	if(wwbs != null) {
        		dataMap.put("functionsol", wwbs.getFunctionsol());
        	}
        	List<Function> funs = systemAnalService.findFunction(38);
        	String comStr = "";
        	if(funs.size() > 0) {
    			Function fun = funs.get(0);
    			dataMap.put("system", fun.getSystem());
            	dataMap.put("function", fun.getFunction());
            	dataMap.put("component", fun.getComponent());
            	comStr = fun.getComponent();
    		}
        	String[] com = comStr.split("，");
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
        	
        	List<ComFun> comfuns = systemAnalService.finComFun(38);
        	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
        	String[] para = new String[]{"有益","有害"};
        	String[] level = new String[]{"适当","不足","过度"};
    		for(int i=0;i<comfuns.size();i++) {
    			int y = 0;
    			int x = 0;
    			ComFun cf = comfuns.get(i);
    			Map<String,Object> map = new HashMap<String,Object>();  
				map.put("id", i+1);
				map.put("precom", cf.getPrename());
				map.put("fun", cf.getFunction());
				map.put("lastcom", cf.getAftername());
				map.put("para", cf.getPara());
				map.put("type", para[cf.getType()-1]);
				map.put("level", level[cf.getLevel()-1]);
				for(int j=0;j<com.length;j++) {
					if(cf.getPrename().equals(com[j])) {
						x = j;
					}
					if(cf.getAftername().equals(com[j])) {
						y = j;
					}
				}
				com1.get(x+1).set(y+1, "+");
                list.add(map); 
    		}

        	dataMap.put("com1out", com1);
    		dataMap.put("com2", list); 
    		dataMap.put("funImg", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/funImg38.png"));
    		
        	
            configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("fun.ftl");

            File outFile = new File("F:/temp/fun"+ "" +".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void TestSolveProblem() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		WordService wordService = (WordService) context.getBean("wordService");
		SolveProblemService solveProblemService = (SolveProblemService) context.getBean("solveProblemService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	WordWithBLOBs wwbs = wordService.findWord(38);
        	if(wwbs != null) {
        		dataMap.put("idealsol", wwbs.getIdealsol());
        		dataMap.put("techsol", wwbs.getTechsol());
        		dataMap.put("physol", wwbs.getPhysol());
        		dataMap.put("objsol", wwbs.getObjsol());
        	}
        	List<IdealRes> irs = solveProblemService.findIdealRes(38);
    		if(irs.size()>0) {
    			IdealRes ir = irs.get(0);
    			dataMap.put("aim", ir.getAim());
    			dataMap.put("result", ir.getResult());
    			dataMap.put("obstacle", ir.getObstacle());
    			dataMap.put("obs_res", ir.getObsRes());
    			dataMap.put("condition", ir.getCond());
    			dataMap.put("resource", ir.getResource());
    		}
    		List<Tech> tech = solveProblemService.findtech(38);
    		String[] para = {"1、运动物体的重量","2、静止物体的重量","3、运动物体的长度","4、静止物体的长度","5、运动物体的面积","6、静止物体的面积","7、运动物体的体积","8、静止物体的体积","9、速度","10、力","11、应力或压力","12、形状","13、结构的稳定性","14、强度","15、运动物体作用时间","16、静止物体作用时间","17、温度","18、光照度","19、运动物体的能量","20、静止物体的能量","21、功率","22、能量损失","23、物质损失","24、信息损失","25、时间损失","26、物质或事物的数量","27、可靠性","28、测试精度","29、制造精度","30、物体外部有害因素作用的敏感性","31、物体产生的有害因素因素","32、可制造性","33、可操作性","34、可维修性","35、适应性及多用性","36、装置的复杂性","37、监控与测试的困难程度","38、自动化程度","39、生产率"};
    		if(tech.size()>0) {
    			Tech t = tech.get(0);
    			dataMap.put("A1", t.getA1());
    			dataMap.put("A2", t.getA2());
    			dataMap.put("B1", t.getB1());
    			dataMap.put("B2", t.getB2());
    			dataMap.put("C1", t.getC1());
    			dataMap.put("C2", t.getC2());
    			dataMap.put("tech_con", t.getTechCon());
    			dataMap.put("com1", t.getCom1());
    			dataMap.put("com2", t.getCom2());
    			dataMap.put("com3", t.getCom3());
    			dataMap.put("improve", para[t.getImprove()-1]);
    			dataMap.put("worse", para[t.getWorse()-1]);
    			List<Principle> prins = solveProblemService.getMatrixPrinciple(t);
    			String prinStr = "";
    			for(int i=0;i<prins.size();i++) {
    				prinStr += prins.get(i).getId() + "、" + prins.get(i).getName();
    			}
    			
    			dataMap.put("principles", prinStr);
    		}
    		List<Physical> phys = solveProblemService.findPhy(38);
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
    			dataMap.put("condition", phy.getCond());
    			dataMap.put("part", phy.getWhole());
    		}
    		List<ObjFieldWithBLOBs> ofs = solveProblemService.findObjectField(38);
    		String[] name = new String[]{"不完整模型","有害效应的完整模型","效应不足的完整模型"};
    		String[] desc = new String[]{"是第一类模型，不完整模型，有一个一般解法","是第二类模型，有害效应的完整模型，有两个一般解法","是第三类模型，效应不足的完整模型，有三个一般解法"};
    		String[][] ofDesc = new String[][]{{"一般解法1：补齐所缺失的元素，增加场F或工具S2，完整模型。"},{"一般解法2：加入第3种物质S3，S3用来阻止有害作用。S3可以是通过S1或S2改变而来，或者是S1/S2共同改变而来。","一般解法3：增加另外一个场F2来抵消原来有害场F的效应。"},{"一般解法4：用另一个场F2（或者F2和S3一起）代替原来的场F1（或者F1和S2一起）。","一般解法5：增加另外一个场F2来强化有用的效应。","一般解法6：插进一个物质S3并加上另一个场F2来提高有用效应。"}};
    		if(ofs.size() > 0) {
    			ObjFieldWithBLOBs of = ofs.get(0);
    			dataMap.put("name", name[of.getType()-1]);
    			dataMap.put("text", of.getTxt());
    			dataMap.put("desc", desc[of.getType()-1]);
    			dataMap.put("model0Img", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/model0Img38.png"));
    			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
    			
    			for(int i=0;i<of.getType();i++) {
    				Map<String,Object> map = new HashMap<String,Object>();
    				map.put("desc", ofDesc[of.getType()-1][i]);
    				map.put("modelImg", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/model" + (i+1) + "Img38.png"));
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
    			dataMap.put("modelList", list);
    		}
    		
    		
    		
        	
        	
            configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("sol_pro.ftl");

            File outFile = new File("F:/temp/sol_pro"+ "" +".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void TestFinal() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		WordService wordService = (WordService) context.getBean("wordService");
		ArrangeAndEvaluateService arrangeAndEvaluateService = (ArrangeAndEvaluateService) context.getBean("arrangeAndEvaluateService");
	//	System.out.println(problemDescrService);
		configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	WordWithBLOBs wwbs = wordService.findWord(38);
        	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
        	if(wwbs != null) {
        		for(int i=0;i<8;i++) {
    				Map<String,Object> map = new HashMap<String,Object>();
    				switch(i+1) {
    				case 1:map.put("sol", wwbs.getCausalsol());
    					break;
    				case 2:map.put("sol", wwbs.getNinesol());
					break;
    				case 3:map.put("sol", wwbs.getResourcesol());
					break;
    				case 4:map.put("sol", wwbs.getFunctionsol());
					break;
    				case 5:map.put("sol", wwbs.getIdealsol());
					break;
    				case 6:map.put("sol", wwbs.getTechsol());
					break;
    				case 7:map.put("sol", wwbs.getPhysol());
					break;
    				case 8:map.put("sol", wwbs.getObjsol());
					break;
    				}
    				map.put("img", this.getImageStr("F:/Java/tomcat9.0.0.M11/webapps/AidInnovation/images/radar" + (i+1) + "Img38.png"));
//    				map.put("sol", wwbs.getCausalsol());
    				list.add(map);
    			}
        		dataMap.put("eva", list);
            	dataMap.put("finalsolution", wwbs.getFinalsol());
        	}
    		
    		
    		
        	
        	
            configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("evaluate.ftl");

            File outFile = new File("F:/temp/evaluate"+ "" +".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private String getImageStr(String path) {
		 InputStream in = null;
		 byte[] data = null;
		 try {
			 in = new FileInputStream(path);
			 data = new byte[in.available()];
			 in.read(data);
			 in.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 BASE64Encoder encoder = new BASE64Encoder();
		 return encoder.encode(data);
	 }
}
