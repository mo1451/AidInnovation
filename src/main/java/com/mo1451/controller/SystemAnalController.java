/**
 * 
 */
package com.mo1451.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mo1451.model.Cause;
import com.mo1451.model.ComFun;
import com.mo1451.model.Function;
import com.mo1451.model.Ninescreen;
import com.mo1451.model.Source;
import com.mo1451.model.WordWithBLOBs;
import com.mo1451.service.ImgService;
import com.mo1451.service.SystemAnalService;
import com.mo1451.service.WordService;

import sun.misc.BASE64Decoder;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class SystemAnalController {

	private SystemAnalService systemAnalService;
	private ImgService imgService;
	private WordService wordService;

	
	@RequestMapping("/CausalImgJson")
	public @ResponseBody String causalImgJson(HttpServletRequest request,String dataURL,String wordId) {
		BASE64Decoder decoder = new BASE64Decoder();
		dataURL = dataURL.replace(" ", "+");//ajax传输过来的数据所有"+"都变成了" ".
		try {
			byte[] b = decoder.decodeBuffer(dataURL);//转码得到图片数据
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			BufferedImage bi1 = ImageIO.read(bais);
			String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId);
			File w1 = new File(path);
			if(!w1.exists()) {
				w1.mkdir();
			}
			File w2 = new File(path+"/cauImg.png");
			ImageIO.write(bi1, "png", w2);
			this.imgService.saveCauImgPath(w2.getPath(), wordId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "sucess";
		return str;
	}
	
	@RequestMapping("/Causal")
	public String causal(HttpServletRequest request,Model model) {
		String strWordId = request.getParameter("wordId");
		int wordId = Integer.parseInt(strWordId);
		model.addAttribute("wordId", wordId);
		String mainReason = request.getParameter("mainreason");
		this.systemAnalService.updateMainCause("mainreason", mainReason,wordId);
		String[] changedWord = request.getParameterValues("changedWord");
		String[] newWord = request.getParameterValues("newWord");
		String[] deletedWord = request.getParameterValues("deletedWord");
		String solution1 = request.getParameter("solution1");
		if(solution1 != null && !solution1.equals("")) {
			this.wordService.updateSolution1(solution1,wordId);
		}
		if(newWord != null) {
			for(int i=0;i<newWord.length;i++) {
//				System.out.println(request.getParameter(newWord[i]) );
				this.systemAnalService.addCause(newWord[i], request.getParameter(newWord[i]), wordId);
			}
		}
		if(changedWord != null) {
			for(int i=0;i<changedWord.length;i++) {
//				System.out.println(changedWord[i]);
				this.systemAnalService.updateCause(changedWord[i], request.getParameter(changedWord[i]),wordId);
			}
		}
		if(deletedWord != null) {
			for(int i=0;i<deletedWord.length;i++) {
				this.systemAnalService.deleteCause(deletedWord[i],wordId);
			}
		}
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getCausalsol() != null) {
			model.addAttribute("solution1", wwbs.getCausalsol());
		}
		List<Cause> causes = this.systemAnalService.checkCause(wordId);
		if(causes.size() > 0) {
			int count22 = 0;
			int[] count32 = new int[50];
			int pid1 = 0;
			int pid2 = 0;
			int pid3 = 0;
			int compare = 0;
			for(int i=0;i<causes.size();i++) {
				Cause cause = causes.get(i);
				if(cause.getPid() == pid1) {
			//		mainReason2 = cause.getTxt();
					pid2 = cause.getId();
					model.addAttribute("mainreason", cause.getTxt());
					for(int j=0;j<causes.size();j++) {
						cause = causes.get(j);
						if(cause.getPid() == pid2) {
							compare = Integer.parseInt(cause.getName().substring(cause.getName().length()-2));
							if(compare > count22 ) {
								count22 = compare;
							}
			//				reason22[j] = cause.getTxt();
							pid3 = cause.getId();
							model.addAttribute(cause.getName(),cause.getTxt());
							
							for(int k=0;k<causes.size();k++) {
								cause = causes.get(k);
								if(cause.getPid() == pid3) {
									compare = Integer.parseInt(cause.getName().substring(cause.getName().length()-2));
									int level2 = Integer.parseInt(cause.getName().substring(8, 10));
									if(compare > count32[level2]) {
										count32[level2] = compare;
									}
			//						reason32[j][k] = cause.getTxt();
									model.addAttribute(cause.getName(), cause.getTxt());
										
									
								}
							}
						}
					}
				}
			}
			model.addAttribute("count2", count22);
			for(int i=1;i<=count22;i++) {
				model.addAttribute("count3-" + i, count32[i]);
//				System.out.println(count32[i]);
			}
		} else {
			
//			this.systemAnalService.addCause(mainReason,reason2,reason3,wordId);
		}
////		System.out.println(strCount2);
		return "center/causal";
	}
	
	@RequestMapping("/nineScreen")
	public String nineScreen(HttpServletRequest request,Model model) {
		String solution2 = request.getParameter("solution2");
		String strWordId = request.getParameter("wordId");
		int wordId = Integer.parseInt(strWordId);
		if(solution2!= null && !solution2.equals("")) {
			this.wordService.updateSolution2(solution2, wordId);
		}
		String name = "";
		String screen = "";
		for(int i=1;i<=9;i++) {
			name = "screen" + i;
			screen = request.getParameter(name);
			if(screen != null && !screen.equals("")) {
				this.systemAnalService.updateOrAddScreen(name, screen, wordId);
			//	model.addAttribute(name, ns.getTxt());
			}
		}
		
		
		List<Ninescreen> ns = this.systemAnalService.getNineScreens(wordId);
		for(int i=0;i<ns.size();i++) {
			model.addAttribute(ns.get(i).getName(), ns.get(i).getTxt());
		}		
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getNinesol() != null) {
			model.addAttribute("solution2", wwbs.getNinesol());
		}
		model.addAttribute("wordId", wordId);
		return "center/nineScreen";
	}
	
	@RequestMapping("/Life")
	public String Life(HttpServletRequest request,Model model) {
		String solution3 = request.getParameter("solution3");
		String strWordId = request.getParameter("wordId");
		int wordId = Integer.parseInt(strWordId);
		if(solution3!= null && !solution3.equals("")) {
			this.wordService.updateSolution3(solution3, wordId);
		}


		
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getLifesol() != null) {
			model.addAttribute("solution3", wwbs.getLifesol());
		}
		model.addAttribute("wordId", wordId);
		return "center/life";
	}
	
	@RequestMapping("/Source")
	public String Source(HttpServletRequest request,Model model) {
		String solution4 = request.getParameter("solution4");
		String strWordId = request.getParameter("wordId");
		String strCountSource = request.getParameter("countSource");
		String[] delete = request.getParameterValues("delete");
		int[] deleteId = new int[delete!=null?delete.length:0];
		String[] deleteValue = new String[delete!=null?delete.length:0];
		String name = "";
		String type = "";
		String system = "";
		String quantity = "";
		String quality = "";
		String value = "";
		String usable = "";
		int countSource = 1;
		int wordId = Integer.parseInt(strWordId);
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(solution4!= null && !solution4.equals("")) {
			this.wordService.updateSolution4(solution4, wordId);
		}
		if(delete != null) {
			for(int i=0;i<delete.length;i++) {
				String deleteName = delete[i].split(",")[0];
				deleteValue[i] = delete[i].split(",")[1];
				deleteId[i] = Integer.parseInt(deleteName.substring(deleteName.length() - 1));
			}
			this.systemAnalService.deleteSource(deleteValue);
		//	System.out.println(delete[0]);			
		}

		
		if(strCountSource != null && !strCountSource.equals("")) {
			countSource = Integer.parseInt(strCountSource);
			int k = 1;
			for(int i=1;i<=countSource;i++) {
				boolean flag = true;
				if(delete != null) {
					while(flag) {
						for(int j=0;j<delete.length;j++) {
							if(k == deleteId[j]) {
								k++;
							} else {
								flag = false;
							}
						}
					}
				}
				name = request.getParameter("name" + k);
				type = request.getParameter("type" + k);
				system = request.getParameter("system" + k);
				value = request.getParameter("value" + k);
				quantity = request.getParameter("quantity" + k);
				quality = request.getParameter("quality" + k);
				usable = request.getParameter("usable" + k);
				this.systemAnalService.addOrUpdateSource(name,type,system,value,quantity,quality,usable,wordId);
				k ++;
			}
		}
		
		
		List<Source> sources = this.systemAnalService.findSource(wordId);
		if(sources.size() > 0) {
			countSource = sources.size();
			for(int i=0;i<countSource;i++) {
				Source source = sources.get(i);
				model.addAttribute("name" + (i+1), source.getName());
				model.addAttribute("type" + (i+1), source.getType());
				model.addAttribute("system" + (i+1), source.getSystem());
				model.addAttribute("value" + (i+1), source.getValue());
				model.addAttribute("quantity" + (i+1), source.getQuantity());
				model.addAttribute("quality" + (i+1), source.getQuality());
				model.addAttribute("usable" + (i+1), source.getUsable());
				
			}
		}
		if(wwbs.getResourcesol() != null) {
			model.addAttribute("solution4", wwbs.getResourcesol());
		}
		model.addAttribute("wordId", wordId);
		model.addAttribute("countSource", countSource);
		return "center/source";
	}
	
	@RequestMapping("/ComJson")
	public @ResponseBody int[][] ComJson(int wordId) {
		List<ComFun> comfuns = this.systemAnalService.finComFun(wordId);
		List<Function> funs = this.systemAnalService.findFunction(wordId);
		String[] com = new String[]{""};
		if(funs.size() > 0) {
			Function fun = funs.get(0);
			com = fun.getComponent().split("，");
		}
		int[][] comPosition = new int[comfuns.size()][2];
		for(int i=0;i<comfuns.size();i++) {
			ComFun cf = comfuns.get(i);
			String prename = cf.getPrename();
			String aftername = cf.getAftername();
			for(int j=0;j<com.length;j++) {
				if(prename.equals(com[j])) {
					comPosition[i][0] = j+1;
				}
				if(aftername.equals(com[j])) {
					comPosition[i][1] = j+1;
				}
			}
		}
	//	System.out.println(comPosition);
		return comPosition;
	}
	
	@RequestMapping("/ComChangeJson")
	public @ResponseBody String ComChangeJson(int wordId,String val,String txt) {
		if(val.equals("notrelative")) {
			this.systemAnalService.deleteCom(txt,wordId);
			
		} else {
			this.systemAnalService.addCom(txt,wordId);
		}
		return "sucess";
	}
	
	@RequestMapping("/FunJson")
	public @ResponseBody String[][] FunJson(@RequestBody Map map) {
		int wordId = Integer.parseInt(map.get("wordId") + "");
//		System.out.println((String)map.get("seltext"));
//		System.out.println(wordId);
		String[][] data = this.systemAnalService.getComFunPara(wordId,(String)map.get("seltext"));
		return data;
	}
	
	@RequestMapping("/FunImgJson")
	public @ResponseBody String FunImgJson(HttpServletRequest request,String dataURL,String wordId) {
		BASE64Decoder decoder = new BASE64Decoder();
		dataURL = dataURL.replace(" ", "+");//ajax传输过来的数据所有"+"都变成了" ".
		try {
			byte[] b = decoder.decodeBuffer(dataURL);//转码得到图片数据
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			BufferedImage bi1 = ImageIO.read(bais);
			String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId);
			File w1 = new File(path);
			if(!w1.exists()) {
				w1.mkdir();
			}
			File w2 = new File(path+"/funImg.png");
			ImageIO.write(bi1, "png", w2);
			this.imgService.saveFunImg(w2.getPath(), wordId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "sucess";
		return str;
	}
	
	@RequestMapping("/Function")
	public String Function(HttpServletRequest request,Model model) {
		String solution5 = request.getParameter("solution5");
		String strWordId = request.getParameter("wordId");
		String system = request.getParameter("system");
		String function = request.getParameter("function");
		String component = request.getParameter("component");
		String[] relative= request.getParameterValues("relative"); 
		String[] preAfter = request.getParameterValues("preAfter");
		String[] func = request.getParameterValues("func");
		String[] para = request.getParameterValues("para");
		String[] funtype = request.getParameterValues("funtype");
		String[] level = request.getParameterValues("level");
		int wordId = Integer.parseInt(strWordId);
		if(solution5!= null && !solution5.equals("")) {
			this.wordService.updateSolution5(solution5, wordId);
		}
		this.systemAnalService.addOrUpadate(system,function,component,wordId);
		if(relative != null && !relative.equals("")) {
			this.systemAnalService.addOrUpdateRelative(relative,wordId);
		}
		/*if(preAfter != null) {
		System.out.println(preAfter[1]);
		System.out.println(func[1]);
		}*/
		this.systemAnalService.updateComFun(preAfter,func,para,funtype,level,wordId);
		
		
		/*List<ComFun> comfuns = this.systemAnalService.finComFun(wordId);
		if(comfuns.size() > 0) {
			model.addAttribute("cfs",comfuns);
		}*/
		List<Function> funs = this.systemAnalService.findFunction(wordId);
		if(funs.size() > 0) {
			Function fun = funs.get(0);
			model.addAttribute("system", fun.getSystem());
			model.addAttribute("function", fun.getFunction());
			model.addAttribute("component", fun.getComponent());
		}
		WordWithBLOBs wwbs = this.wordService.getWordWithBLOBs(wordId);
		if(wwbs.getFunctionsol() != null) {
			model.addAttribute("solution5", wwbs.getFunctionsol());
		}
		model.addAttribute("wordId", wordId);
		return "center/function";
	}


	public SystemAnalService getSystemAnalService() {
		return systemAnalService;
	}

	@Resource
	public void setSystemAnalService(SystemAnalService systemAnalService) {
		this.systemAnalService = systemAnalService;
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
