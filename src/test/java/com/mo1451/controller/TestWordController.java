/**
 * 
 */
package com.mo1451.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.*;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
public class TestWordController {

	private MockMvc mockMvc;  
    @Autowired  
    private WordController wordController;  
    @Before  
    public void setUp() throws Exception {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //配置视图解析器
        resolver.setPrefix("/WEB_INF/views");
        resolver.setSuffix(".jsp");
         mockMvc = MockMvcBuilders.standaloneSetup(wordController).setViewResolvers(resolver).build();  
    }  
	
	@Test
	@Transactional
	public void testCreateWord() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/center/createWord")
				.param("userId", "2")
				.param("username", "aaa"))  
        .andExpect(MockMvcResultMatchers.view().name("redirect:Main"))
        .andExpect(MockMvcResultMatchers.model().attribute("userId", 2))
        .andExpect(MockMvcResultMatchers.model().attribute("wordId", notNullValue()))
        .andExpect(MockMvcResultMatchers.model().attribute("username", "aaa"))
        .andDo(print())
        .andReturn(); 
	}
	
	@Test
	@Transactional
	public void testdeleteWordJson() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/center/deleteWordJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("wordId","2"))
	//	.andExpect(jsonPath("str").value("删除成功"))
		.andDo(print())
		.andReturn();
	}

}
