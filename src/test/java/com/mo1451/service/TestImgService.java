/**
 * 
 */
package com.mo1451.service;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author 默1451
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:beans.xml"})
public class TestImgService {

	@Resource
	private ImgService imgService;
	private int wordId = 38;
	
	/**
	 * Test method for {@link com.mo1451.service.ImgService#createImgTable(int)}.
	 */
	@Test
	public void testCreateImgTable() {
		this.imgService.createImgTable(wordId);
	}

	/**
	 * Test method for {@link com.mo1451.service.ImgService#getImgMapper()}.
	 */
	@Test
	public void testGetImgMapper() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.service.ImgService#setImgMapper(com.mo1451.mapper.ImgMapper)}.
	 */
	@Test
	public void testSetImgMapper() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSaveLifeImg() throws Exception{
		Class<ImgService> class1 = ImgService.class;
		Method method = class1.getDeclaredMethod("saveLifeImg", int.class);
		method.setAccessible(true);
		method.invoke(class1.newInstance(), 6);
	}
	
	@Test
	public void testSaveObjectImgPath() {
		String[] path = new String[]{"aa","bb","cc","d"};
		this.imgService.saveObjectImgPath(path, wordId);
	}
	
	@Test
	public void testSaveImgService() {
		this.imgService.saveImgService(38);
	}

}
