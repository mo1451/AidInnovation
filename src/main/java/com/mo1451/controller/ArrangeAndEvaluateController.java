/**
 * 
 */
package com.mo1451.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mo1451.service.ArrangeAndEvaluateService;
import com.mo1451.service.ImgService;
import com.mo1451.service.WordService;

import sun.misc.BASE64Decoder;

/**
 * @author 默1451
 *
 */
@Controller
@RequestMapping("/center")
public class ArrangeAndEvaluateController {
	private ArrangeAndEvaluateService arrangeAndEvaluteService;
	private WordService wordService;
	private ImgService imgService;

	public ArrangeAndEvaluateService getArrangeAndEvaluteService() {
		return arrangeAndEvaluteService;
	}

	@Resource
	public void setArrangeAndEvaluteService(ArrangeAndEvaluateService arrangeAndEvaluteService) {
		this.arrangeAndEvaluteService = arrangeAndEvaluteService;
	}
	
	@RequestMapping("/SummerImgJson")
	public @ResponseBody String SummerImgJson(HttpServletRequest request,int wordId,String id,String dataURL) {
		BASE64Decoder decoder = new BASE64Decoder();
		int imgId = Integer.parseInt(id.substring(id.length()-1));
		dataURL = dataURL.replace(" ", "+");//ajax传输过来的数据所有"+"都变成了" ".
//		System.out.println(imgId);
		try {
			byte[] b = decoder.decodeBuffer(dataURL);//转码得到图片数据
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			BufferedImage bi1 = ImageIO.read(bais);
			String path = request.getSession().getServletContext().getRealPath("/images/word" + wordId);
			File w1 = new File(path);
			if(!w1.exists()) {
				w1.mkdir();
			}
			File w2 = new File(path+"/summerImg" + imgId + ".png");
			ImageIO.write(bi1, "png", w2);
			this.imgService.saveSummerImgPath(w2.getPath(), wordId,imgId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping("/Summer")
	public String Summer(HttpServletRequest request,Model model){		
		int wordId = Integer.parseInt(request.getParameter("wordId"));
		String finalSolu = request.getParameter("solu");
		String[][] strRadar = new String[8][6];
		for(int i=0;i<8;i++) {
			strRadar[i] = request.getParameterValues("radar" + (i+1));
		}
		this.arrangeAndEvaluteService.UpdateOrSaveRadar(strRadar,wordId);
		this.wordService.updateFianlSolu(finalSolu,wordId);
		
		strRadar = this.arrangeAndEvaluteService.getRader(wordId);
		String[] solu = this.arrangeAndEvaluteService.getSolu(wordId);
		model.addAttribute("radar", strRadar);
		model.addAttribute("solu", solu);
		model.addAttribute("wordId", wordId);		
		return "center/summer";
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
