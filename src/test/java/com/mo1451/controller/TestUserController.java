/**
 * 
 */
package com.mo1451.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mo1451.model.User;

/**
 * @author 默1451
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:beans.xml"})
public class TestUserController {

	private MockMvc mockMvc;  
	private String userName = "testUserName";
	private String userEmail = "testUserEmail";
	private String userPassword = "testUserPassword";
    @Autowired  
    private UserController userController;  
    @Before  
    public void setUp() throws Exception {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //配置视图解析器
        resolver.setPrefix("/WEB_INF/views");
        resolver.setSuffix(".jsp");
         mockMvc = MockMvcBuilders.standaloneSetup(userController).setViewResolvers(resolver).build();  
    }  

	@Test
	@Transactional
	//@Rollback(false)
	public void testRegister() throws Exception {
		//fail("Not yet implemented");
		mockMvc.perform(MockMvcRequestBuilders.get("/register"))  
        .andExpect(MockMvcResultMatchers.view().name("register"))
        .andDo(print())
        .andReturn(); 
	}

	@Test
	@Transactional
	public void testAddUser() throws Exception {
		MultiValueMap<String,String> userMap = new LinkedMultiValueMap<String,String>();
		userMap.add("name", userName);
		userMap.add("email", userEmail);
		userMap.add("password", userPassword);
		mockMvc.perform(MockMvcRequestBuilders.post("/addUser").params(userMap))
			.andExpect(MockMvcResultMatchers.view().name("mail"))
			.andReturn();
	}
	
	@Test
	public void testCodeJson() throws Exception {
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("verCode", "7576");
		mockMvc.perform(MockMvcRequestBuilders.post("/codeJson")
				.session(session)
				.accept(MediaType.APPLICATION_JSON)
				.param("verifycode","7576"))
		.andExpect(jsonPath("valid").value("true"))
		.andDo(print())
		.andReturn();
		mockMvc.perform(MockMvcRequestBuilders.post("/codeJson")
				.session(session)
				.accept(MediaType.APPLICATION_JSON)
				.param("verifycode","7577"))
		.andExpect(jsonPath("valid").value("false"))
		.andDo(print())
		.andReturn();
	}
	@Test
	public void testUserJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/userJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("username","7576"))
		.andExpect(jsonPath("valid").value("true"))
		.andDo(print())
		.andReturn();
		mockMvc.perform(MockMvcRequestBuilders.post("/userJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("username","aaa"))
		.andExpect(jsonPath("valid").value("false"))
		.andDo(print())
		.andReturn();
	}
	
	@Test
	public void testEamilJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/emailJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("email","7576"))
		.andExpect(jsonPath("valid").value("true"))
		.andDo(print())
		.andReturn();
		mockMvc.perform(MockMvcRequestBuilders.post("/emailJson")
				.accept(MediaType.APPLICATION_JSON)
				.param("email","1451837861@qq.com"))
		.andExpect(jsonPath("valid").value("false"))
		.andDo(print())
		.andReturn();
	}

	@Test
	@Transactional
	public void testIdentity() throws Exception{
		String uuidId2 = "cba746d4-adee-4556-b3e8-9016a3502191";
		String uuidId19 = "76ca90b2-b334-47a2-b041-45c7d66abdb6";
		String msgYes = "恭喜您，激活成功！";
		String msgNo = "注册链接无效！<br>或许您已激活。";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/identity").param("uuid",uuidId2).param("id", "2"))
		.andExpect(MockMvcResultMatchers.view().name("checkIdentity"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", msgNo))
		.andDo(print())
		.andReturn();
		mockMvc.perform(MockMvcRequestBuilders.post("/identity").param("uuid",uuidId19).param("id", "19"))
		.andExpect(MockMvcResultMatchers.view().name("checkIdentity"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", msgYes))
		.andDo(print())
		.andReturn();
	}

	@Test
	public void testSignIn() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/signin"))
		.andExpect(MockMvcResultMatchers.view().name("signin"))
		.andDo(print())
		.andReturn();
	}

	@Test
	public void testCheckPassword() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/checkPassword")
				.param("username", "aaa")
				.param("password", "aa"))
		.andExpect(MockMvcResultMatchers.view().name("redirect:center/userCenter"))
		.andDo(print())
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/checkPassword")
				.param("username", "aaa")
				.param("password", "aaa"))
		.andExpect(MockMvcResultMatchers.view().name("signin"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "用户名或密码错误"))
		.andDo(print())
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/checkPassword")
				.param("username", "aa")
				.param("password", "aa"))
		.andExpect(MockMvcResultMatchers.view().name("signin"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "用户名或密码错误"))
		.andDo(print())
		.andReturn();
	}

	@Test
	public void testSaveUserCookies() throws Exception {
		MockHttpServletResponse response = new MockHttpServletResponse();
		User u = new User();
		u.setId(123);
		Class<UserController> class1 = UserController.class;
		Method method = class1.getDeclaredMethod("saveUserCookies", new Class[]{HttpServletResponse.class,User.class});
		method.setAccessible(true);
		method.invoke(class1.newInstance(), new Object[]{response,u});
	}
	
	@Test
	public void testUserCenter() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/center/userCenter")
				.param("userId", "2")
				.param("wordId", "38")
				.param("username", "aaa"))
		.andExpect(MockMvcResultMatchers.view().name("/center/usercenter"))
		.andExpect(MockMvcResultMatchers.model().attribute("userId", 2))
		.andExpect(MockMvcResultMatchers.model().attribute("wordId", 38))
		.andExpect(MockMvcResultMatchers.model().attribute("username", "aaa"))
		.andDo(print())
		.andReturn();
		
		
		Cookie cookie = new Cookie("userId","2");
		mockMvc.perform(MockMvcRequestBuilders.post("/center/userCenter")
				.cookie(cookie))
		.andExpect(MockMvcResultMatchers.view().name("/center/usercenter"))
		.andExpect(MockMvcResultMatchers.model().attribute("userId", 2))
		.andExpect(MockMvcResultMatchers.model().attribute("username", "aaa"))
		.andDo(print())
		.andReturn();
	}
	
	
	/**
	 * 不知道如何给cookie设值
	 * @throws Exception
	 */
	@Test
	public void testgetUserFromCookies() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		response.addCookie(new Cookie("userId","2"));
		Class<UserController> class1 = UserController.class;
		Method method = class1.getDeclaredMethod("getUserFromCookies", HttpServletRequest.class);
		method.setAccessible(true);
		User u = (User) method.invoke(class1.newInstance(), request);
		System.out.println(u);
		assertThat(u,equalTo(null));
	}
	
	@Test
	@Transactional
	public void testsendChangePasswordEmail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/sendChangePasswordEmail")
				.param("email", "1451837861@qq.com"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("resetpassword"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "请到邮箱重设你的密码。"))
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/sendChangePasswordEmail"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("forgetpassword"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "请填写邮箱"))
		.andReturn();
	}

	@Test
	@Transactional
	public void testResetPassword() throws Exception{
		UUID uuid = UUID.fromString("cba746d4-adee-4556-b3e8-9016a3502191");
		String rightUuid = "cba746d4-adee-4556-b3e8-9016a3502191";
		String wrongUuid = "aaa";
		String email = "1451837861@qq.com";
		mockMvc.perform(MockMvcRequestBuilders.post("/resetPassword")
				.sessionAttr("uuid", uuid)
				.param("email", email)
				.param("uuid", rightUuid))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("resetpassword"))
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/resetPassword")
				.sessionAttr("uuid", uuid)
				.param("email", email)
				.param("uuid", wrongUuid))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("forgetpassword"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "链接失效，请重新激活"))
		.andReturn();
	}

	@Test
	@Transactional
	public void testChangePassword() throws Exception {
		String email = "1451837861@qq.com";
		String wrongEmail = "adasfasd";
		String password = "newPassword";
		mockMvc.perform(MockMvcRequestBuilders.post("/changePassword")
				.param("email", email)
				.param("password", password))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("changed"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "修改成功"))
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/changePassword")
				.param("email", wrongEmail)
				.param("password", password))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("forgetpassword"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "该用户不存在！"))
		.andReturn();
	}

	@Test
	@Transactional
	public void testMain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/center/Main")
				.param("userId", "2")
				.param("username", "aaa")
				.param("wordId", "38"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("/center/main"))
		.andExpect(MockMvcResultMatchers.model().attribute("userId", 2))
		.andExpect(MockMvcResultMatchers.model().attribute("username", "aaa"))
		.andExpect(MockMvcResultMatchers.model().attribute("wordId", 38))
		.andReturn();
	}

	@Test
	@Transactional
	public void testUserInfo() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/center/userInfo")
				.param("userId", "2"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("/center/userinfo"))
		.andExpect(MockMvcResultMatchers.model().attribute("user", notNullValue()))
		.andReturn();
	}

	@Test
	@Transactional
	public void testChangeInfo() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/center/changeInfo")
				.param("userId", "2")
				.param("sex", "male")
				.param("industry", "testIndustry")
				.param("introduction", "testIntroduction"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("/center/userinfo"))
		.andExpect(MockMvcResultMatchers.model().attribute("user", notNullValue()))
		.andReturn();
	}

	@Test
	@Transactional
	public void testChangePassword2() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/center/changePassword")
				.param("oldpassword", "aa")
				.param("nowpassword", "aaa")
				.param("name", "aaa")
				.param("introduction", "testIntroduction"))
		.andDo(print())
		.andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/center/changePassword")
				.param("oldpassword", "aaas")
				.param("nowpassword", "aaa")
				.param("name", "aaa")
				.param("introduction", "testIntroduction"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("/center/changepassword"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", "密码错误，修改失败。"))
		.andReturn();
	}

	@Test
	@Transactional
	public void testHistoryWord() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/center/historyWord")
				.param("userId", "2")
				)
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("/center/historyword"))
		.andReturn();
	}

	@Test
	@Transactional
	public void testUserOut() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/userOut"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.view().name("redirect:signin"))
		.andExpect(MockMvcResultMatchers.redirectedUrl("signin"))
		.andExpect(MockMvcResultMatchers.cookie().exists("userId"))//.comment("userId", nullValue()))
		.andReturn();
	}

}
