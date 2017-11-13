/**
 * 
 */
package com.mo1451.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mo1451.model.Page;
import com.mo1451.model.User;

/**
 * @author 默1451
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class TestUserService {

	@Resource
	private UserService userService;
	
	@Test
	public void testAddUser() {
		User u = new User();
		u.setEmail("a");
		u.setName("s");
		u.setPassword("wew");
		this.userService.addUser(u);
	//	addUser(u);
	}

	@Test
	public void testGetUserByPage() {
		List<User> users = this.userService.getUsersByPage(new Page(1, 10));
		for(User u : users) {
			System.out.println(u.getName());
		}
	}
	
	@Test
	public void testUserSearch() {
		Page page = new Page(1, 10);
		List<User> users =  userService.search("", "", "a", page);
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
}
