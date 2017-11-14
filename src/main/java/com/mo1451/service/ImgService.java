/**
 * 
 */
package com.mo1451.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.mo1451.mapper.ImgMapper;
import com.mo1451.model.Img;
import com.mo1451.model.ImgExample;
import com.mo1451.util.ImgStr;
import com.mo1451.util.Proper;

/**
 * @author 默1451
 *
 */
@Service
public class ImgService {
	private ImgMapper imgMapper;
	
	public void createImgTable(int wordId) {
		String lifeImgPath = this.saveLifeImg(wordId);
		Img img = new Img();
		img.setWordid(wordId);				
		img.setLifeImg(lifeImgPath);
		this.imgMapper.insertSelective(img);
	}

	/**
	 * @param wordId
	 * @return
	 */
	private String saveLifeImg(int wordId) {
		String originalLifeImgPath = Proper.getRealPath() + "/images/lifeImg.png";
		String parentSavedLifeImgPath = Proper.getRealPath() + "/images/word" + wordId;
		String savedLifeImgPath = parentSavedLifeImgPath + "/lifeImg.png";
		File originalLile = new File(originalLifeImgPath);
		File parentSavedFile = new File(parentSavedLifeImgPath);
		File savedFile = new File(savedLifeImgPath);
		if(!parentSavedFile.exists()) {
			parentSavedFile.mkdirs();
		}
		try {
			BufferedImage bi = ImageIO.read(originalLile);
			ImageIO.write(bi, "png", savedFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savedLifeImgPath;
	}
	
	public void test(int test) {
		System.out.println(test);
	}

	public ImgMapper getImgMapper() {
		return imgMapper;
	}

	@Resource
	public void setImgMapper(ImgMapper imgMapper) {
		this.imgMapper = imgMapper;
	}

	/**
	 * @param path
	 * @param wordId 
	 */
	public void saveCauImgPath(String path, String wordId) {
		Img img = getImg(wordId);
		img.setCaulImg(path);
		this.imgMapper.updateByPrimaryKeySelective(img);
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Img getImg(String wordId) {
		return this.getImg(Integer.parseInt(wordId));
	}

	/**
	 * @param path
	 * @param wordId
	 */
	public void saveFunImg(String path, String wordId) {
		Img img = getImg(wordId);
		img.setFunImg(path);
		this.imgMapper.updateByPrimaryKeySelective(img);
	}

	/**
	 * @param objImgPath
	 * @param wordId
	 */
	public void saveObjectImgPath(String[] objImgPath, int wordId) {
		Img img = getImg(wordId);
		for(int i=0;i<objImgPath.length;i++) {
			try {
				Method method = img.getClass().getDeclaredMethod(("setObjectImg" + i), String.class);
				method.invoke(img, objImgPath[i]);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		this.imgMapper.updateByPrimaryKeySelective(img);
	}

	/**
	 * @param wordId
	 * @return
	 */
	private Img getImg(int wordId) {
		ImgExample imgExample = new ImgExample();
		ImgExample.Criteria criteria = imgExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		List<Img> imgs = this.imgMapper.selectByExample(imgExample);
		if(imgs.size() <= 0) {
			this.createImgTable(wordId);
			Img img = new Img();
			img.setWordid(wordId);	
			return img;
		}
		return imgs.get(0);
	}

	/**
	 * @param parent
	 * @param wordId
	 * @param imgId
	 */
	public void saveSummerImgPath(String path, int wordId, int imgId) {
		Img img = getImg(wordId);
		try {
			Method method = img.getClass().getDeclaredMethod(("setSummerImg" + (imgId)), String.class);
			method.invoke(img, path);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		this.imgMapper.updateByPrimaryKeySelective(img);
	}

	/**
	 * @param wordId
	 * @return
	 */
	public Map<String, String> saveImgService(int wordId) {
		Map<String, String> imgMap = new HashMap<String, String>();
		Img img = this.getImg(wordId);
		Method[] methods = img.getClass().getDeclaredMethods();
		for(Method method : methods) {
			//System.out.println(method.getName());
			String name = method.getName();
			Pattern pattern = Pattern.compile("^get(.*Img($|[0-9]$))");
			Matcher match = pattern.matcher(name);
			if(match.find()) {
				try {
					String path = (String)method.invoke(img);
					String imgName = match.group(1).substring(0, 1).toLowerCase() + match.group(1).substring(1);
					if(path != null && !path.trim().equals("")) {
						String imgStr = ImgStr.getImgStr(path);
						imgMap.put(imgName, imgStr);
					} else {
						imgMap.put(imgName, " ");
					}
				//	System.out.println(path);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			//	String imgName = match.group(1).substring(0, 1).toLowerCase() + match.group(1).substring(1);
			//	System.out.println(imgName);
			}
	/*		if(name.matches("^get.*Img($|[0-9]$)")) {
		//		System.out.println(name);
				try {
					String path = (String)method.invoke(img, null);
					System.out.println(path);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}*/
		}
		/*for(Iterator it = imgMap.entrySet().iterator();it.hasNext();) {
			System.out.println(it.next());
		}*/
//		dataMap.putAll(this.saveProblemDesc(wordId));
		return imgMap;
	}

	/**
	 * @param path
	 */
	public void savePrinImgPath(String path, int wordId) {
		// TODO Auto-generated method stub
		Img img = getImg(wordId);
		img.setPrinImg(path);
		this.imgMapper.updateByPrimaryKeySelective(img);
	}

	/**
	 * @param id
	 */
	public void deleteAll(Integer wordId) {
		ImgExample imgExample = new ImgExample();
		ImgExample.Criteria criteria = imgExample.createCriteria();
		criteria.andWordidEqualTo(wordId);
		imgMapper.deleteByExample(imgExample);
	}
	
	
}
