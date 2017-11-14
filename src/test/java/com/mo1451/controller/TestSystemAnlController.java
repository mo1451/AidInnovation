/**
 * 
 */
package com.mo1451.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author 默1451
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:beans.xml"})
public class TestSystemAnlController {

	private MockMvc mockMvc;  
    @Autowired  
    private SystemAnalController systemAnalController;  
    @Before  
    public void setUp() throws Exception {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //配置视图解析器
        resolver.setPrefix("/WEB_INF/views");
        resolver.setSuffix(".jsp");
         mockMvc = MockMvcBuilders.standaloneSetup(systemAnalController).setViewResolvers(resolver).build();  
    }  
	
	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#causalImgJson(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCausalImgJson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#causal(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
	 */
	@Test
	public void testCausal() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#nineScreen(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
	 */
	@Test
	public void testNineScreen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#Life(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
	 */
	@Test
	public void testLife() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#Source(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
	 */
	@Test
	public void testSource() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#ComJson(int)}.
	 */
	@Test
	@Transactional
	public void testComJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/center/ComJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("wordId","38"))
	//	.andExpect(jsonPath("str").value("删除成功"))
		.andDo(print())
		.andReturn();
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#ComChangeJson(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testComChangeJson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#FunJson(java.util.Map)}.
	 */
	@Test
	public void testFunJson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#FunImgJson(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFunImgJson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#Function(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
	 */
	@Test
	public void testFunction() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#getSystemAnalService()}.
	 */
	@Test
	public void testGetSystemAnalService() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#setSystemAnalService(com.mo1451.service.SystemAnalService)}.
	 */
	@Test
	public void testSetSystemAnalService() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#getWordService()}.
	 */
	@Test
	public void testGetWordService() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mo1451.controller.SystemAnalController#setWordService(com.mo1451.service.WordService)}.
	 */
	@Test
	public void testSetWordService() {
		fail("Not yet implemented");
	}

}
