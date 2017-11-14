/**
 * 
 */
package com.mo1451.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.mo1451.mapper.ProblemDescrMapper;
import com.mo1451.model.ProblemDescrExample;
import com.mo1451.model.ProblemDescrWithBLOBs;
import com.mo1451.service.ProblemDescrService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author 默1451
 *
 */
public class CreateWord {
	private Configuration configuration = null;
	private ProblemDescrService problemDescrService = new ProblemDescrService();
	private ProblemDescrMapper problemDescrMapper;

    public CreateWord() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public void createWord(String fileName) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
                dataMap.put("id", 1);
                dataMap.put("name", "aa");
                dataMap.put("normalprice", 99);
                dataMap.put("memberprice", 89);
                dataMap.put("text1", "tes");
                dataMap.put("text2", 546);
      //          dataMap.put("num", 2); 
      //          dataMap.put("class", "班级1"); 
       //         dataMap.put("name2", "名字1");
                
                List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
                for (int i = 0; i < 10; i++) {  
                    Map<String,Object> map = new HashMap<String,Object>();  
                    map.put("num", i);  
                    map.put("name2", "名字" + i);
                    map.put("class", "班级" + i);  
                    list.add(map);  
                }  
                dataMap.put("list", list); 
                
                configuration.setClassForTemplateLoading(this.getClass(), "/"); // FTL文件所存在的位置
                Template template = configuration.getTemplate(fileName + ".ftl");

                File outFile = new File("F:/temp/test"+ "" +".doc");
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
                template.process(dataMap, out);
                out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createPromDescWord() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
        	ProblemDescrWithBLOBs pdwb = this.problemDescrService.checkWordId(38);
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

	public ProblemDescrService getProblemDescrService() {
		return problemDescrService;
	}

	@Resource
	public void setProblemDescrService(ProblemDescrService problemDescrService) {
		this.problemDescrService = problemDescrService;
	}
}
