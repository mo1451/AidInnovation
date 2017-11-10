/**
 * 
 */
package com.mo1451.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mo1451.model.IdealRes;
import com.mo1451.model.ObjFieldWithBLOBs;
import com.mo1451.model.Physical;
import com.mo1451.model.Principle;
import com.mo1451.model.StcOperator;
import com.mo1451.model.Tech;
import com.mo1451.model.WordWithBLOBs;
import com.mo1451.service.ImgService;
import com.mo1451.service.SolveProblemService;
import com.mo1451.service.WordService;

import sun.misc.BASE64Decoder;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class SolveProblemController {

	private SolveProblemService solveProblemService;
	private WordService wordService;
	private ImgService imgService;

	public SolveProblemService getSolveProblemService() {
		return solveProblemService;
	}

	@Resource
	public void setSolveProblemService(SolveProblemService solveProblemService) {
		this.solveProblemService = solveProblemService;
	}
	
	@RequestMapping("/Final")
	public String Final(HttpServletRequest request,Model model) {
		String solution6 = request.getParameter("solution6");
		String strWordId = request.getParameter("wordId");
		String aim = request.getParameter("aim");
		String result = request.getParameter("result");
		String obstacle = request.getParameter("obstacle");
		String obsResult = request.getParameter("obsresult");
		String condition = request.getParameter("condition");
		String resource = request.getParameter("resource");
		int wordId = Integer.parseInt(strWordId);
		if(solution6!= null && !solution6.equals("")) {
			this.wordService.updateSolution6(solution6, wordId);
		}
//		System.out.println(aim);
		this.solveProblemService.addOrUpdateIdealRes(aim,result,obstacle,obsResult,condition,resource,wordId);
		
		List<IdealRes> irs = this.solveProblemService.findIdealRes(wordId);
		if(irs.size()>0) {
			model.addAttribute("idealres", irs.get(0));
		}
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getIdealsol() != null) {
			model.addAttribute("solution6", wwbs.getIdealsol());
		}
		model.addAttribute("wordId", wordId);
		return "center/final";
	}

	@RequestMapping("/StcOperator")
	public String StcOperator(HttpServletRequest request, Model model) {
		int wordId = Integer.parseInt(request.getParameter("wordId"));
		String bigString = request.getParameter("big");
		String smallString = request.getParameter("small");
		String longTimeString = request.getParameter("longTime");
		String shortTimeString = request.getParameter("shortTime");
		String expensiveString = request.getParameter("expensive");
		String chipString = request.getParameter("chip");
		String stcSolutionString = request.getParameter("stcSolution");
		if(bigString != null || smallString != null || longTimeString != null || shortTimeString != null
				|| expensiveString != null || chipString != null) {
			this.solveProblemService.addOrUpdateStcOperator(bigString, smallString, 
					longTimeString, shortTimeString, expensiveString, chipString, wordId);
		}
		

		List<StcOperator> stcOperators = solveProblemService.findStcOperator(wordId);
		if(stcOperators.size() > 0) {
			model.addAttribute("stc", stcOperators.get(0));
		}
		model.addAttribute("wordId", wordId);
		return "center/stcoperator";
	}
	
	@RequestMapping("/techJson")
	public @ResponseBody List<Principle> techJson(int improve,int worse) {
	//	System.out.println(improve);
		Tech t = new Tech();
		t.setImprove(improve);
		t.setWorse(worse);
		
		return this.solveProblemService.getMatrixPrinciple(t);
	}
	
	@RequestMapping("/Technology")
	public String Technology(HttpServletRequest request,Model model) {
		String solution7 = request.getParameter("solution7");
		String strWordId = request.getParameter("wordId");
		String a1 = request.getParameter("A+");
		String a2 = request.getParameter("A-");
		String b1 = request.getParameter("B+");
		String b2 = request.getParameter("B-");
		String c1 = request.getParameter("C-");
		String c2 = request.getParameter("C+");
		String tech_con = request.getParameter("tech_con");
		String com1 = request.getParameter("com1");
		String com2 = request.getParameter("com2");
		String com3 = request.getParameter("com3");
		String improve = request.getParameter("improve");
		String worse = request.getParameter("worse");
		int wordId = Integer.parseInt(strWordId);
		if(solution7!= null && !solution7.equals("")) {
			this.wordService.updateSolution7(solution7, wordId);
		}
	//	System.out.println(aim);
		this.solveProblemService.addOrUpdateTech(a1,a2,b1,b2,c1,c2,tech_con,com1,com2,com3,improve,worse,wordId);
		
		List<Tech> tech = this.solveProblemService.findtech(wordId);
		if(tech.size()>0) {
			Tech t = tech.get(0);
			model.addAttribute("tech", t);
			List<Principle> prins = this.solveProblemService.getMatrixPrinciple(t);
			model.addAttribute("prins", prins);
		}
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getTechsol() != null) {
			model.addAttribute("solution7", wwbs.getTechsol());
		}
		model.addAttribute("wordId", wordId);
		return "center/technology";
	}
	
	@RequestMapping("/Physical")
	public String Physical(HttpServletRequest request,Model model) {
		String solution8 = request.getParameter("solution8");
		String strWordId = request.getParameter("wordId");
		String word11 = request.getParameter("word11");
		String word12 = request.getParameter("word12");
		String word13 = request.getParameter("word13");
		String word21 = request.getParameter("word21");
		String word22 = request.getParameter("word22");
		String word23 = request.getParameter("word23");
		String space = request.getParameter("space");
		String time = request.getParameter("time");
		String cond = request.getParameter("cond");
		String whole = request.getParameter("whole");
		
		int wordId = Integer.parseInt(strWordId);
		this.solveProblemService.addOrUpdatePhysical(word11,word12,word13,word21,word22,word23,space,
				time,cond,whole,wordId);
		if(solution8!= null && !solution8.equals("")) {
			this.wordService.updateSolution8(solution8, wordId);
		}
		
		
		List<Physical> phys = this.solveProblemService.findPhy(wordId);
		if(phys.size() > 0) {
			model.addAttribute("phy", phys.get(0));
		}
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getPhysol() != null) {
			model.addAttribute("solution8", wwbs.getPhysol());
		}
		model.addAttribute("wordId", wordId);
		return "center/physical";
	}
	
	@RequestMapping("/ObjectImgJson")
	@ResponseBody
	public String ObjectImgJson(String[] dataURL,String model,int wordId,HttpServletRequest request) {
		
		BASE64Decoder decoder = new BASE64Decoder();
		int count = Integer.parseInt(model.substring(model.length()-1));
		String[] objImgPath = new String[count+1];
		for(int i=0;i<=count;i++) {
			dataURL[i] = dataURL[i].replace(" ", "+");//ajax传输过来的数据所有"+"都变成了" ".
			try {
				byte[] b = decoder.decodeBuffer(dataURL[i]);//转码得到图片数据
				ByteArrayInputStream bais = new ByteArrayInputStream(b);
				BufferedImage bi1 = ImageIO.read(bais);
				String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId);
				File w1 = new File(path);
				if(!w1.exists()) {
					w1.mkdir();
				}
				File w2 = new File(path+"/objectImg" + i + ".png");
				ImageIO.write(bi1, "png", w2);
				objImgPath[i] = w2.getPath();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.imgService.saveObjectImgPath(objImgPath, wordId);
		return "sucess";
	}
	
	@RequestMapping("/ObjectField")
	public String objectField(HttpServletRequest request,Model model) {
		String solution9 = request.getParameter("solution9");
		String strWordId = request.getParameter("wordId");
		String type = request.getParameter("type");
		
		int wordId = Integer.parseInt(strWordId);
		if(solution9!= null && !solution9.equals("")) {
			this.wordService.updateSolution9(solution9, wordId);
		}
		if(type != null && !type.equals("")) {
			int t = Integer.parseInt(type);
			if(t == 1) {
				String txt = request.getParameter("txt");
				String explain1 = request.getParameter("explain1");
				String[] node1 = request.getParameterValues("node1");
				String[] node2 = request.getParameterValues("node2");
				this.solveProblemService.addOrUpdateObject(txt,explain1,wordId,node1,node2);
			} else if(t == 2) {
				String txt = request.getParameter("txt");
				String explain1 = request.getParameter("explain1");
				String explain2 = request.getParameter("explain2");
				String[] node1 = request.getParameterValues("node1");
				String[] node2 = request.getParameterValues("node2");
				String[] node3 = request.getParameterValues("node3");
				this.solveProblemService.addOrUpdateObject(txt,explain1,explain2,node1,node2,node3,wordId);
			} else if(t == 3) {
				String txt = request.getParameter("txt");
				String explain1 = request.getParameter("explain1");
				String explain2 = request.getParameter("explain2");
				String explain3 = request.getParameter("explain3");
				String[] node1 = request.getParameterValues("node1");
				String[] node2 = request.getParameterValues("node2");
				String[] node3 = request.getParameterValues("node3");
				String[] node4 = request.getParameterValues("node4");
				this.solveProblemService.addOrUpdateObject(txt,explain1,explain2,explain3,node1,node2,node3,node4,wordId);
			}
		}
		
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getObjsol() != null) {
			model.addAttribute("solution9", wwbs.getObjsol());
		}
		List<ObjFieldWithBLOBs> ofs = this.solveProblemService.findObjectField(wordId);
		if(ofs.size() > 0) {
			model.addAttribute("ofwbs", ofs.get(0));
			String[][] str = this.solveProblemService.getNodes(ofs.get(0));
			model.addAttribute("nodes", str);
		}
		model.addAttribute("wordId", wordId);
		return "center/objectField";
	}
	
	public WordService getWordService() {
		return wordService;
	}

	@Resource
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

	public ImgService getImgService() {
		return imgService;
	}

	@Resource
	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}
}
