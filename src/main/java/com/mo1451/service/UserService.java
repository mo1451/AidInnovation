/**
 * 
 */
package com.mo1451.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.mo1451.mail.MailSender;
import com.mo1451.mapper.UserMapper;
import com.mo1451.model.Page;
import com.mo1451.model.User;
import com.mo1451.model.UserExample;
import com.mo1451.model.UserSearch;

/**
 * @author 默1451
 *
 */
@Service
public class UserService {
	private UserMapper userMapper;

	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		this.userMapper.insertSelective(user);
		
	}
	
	public void deleteUserByName(String name) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(name);
		this.userMapper.deleteByExample(userExample);
	}
	
	public void sendCheckMail(User user, UUID uuid) {
		new MailSender().sendMail(uuid,user.getId());
	}
	
	/**
	 * 通过ID得到用户
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {
		return this.userMapper.selectByPrimaryKey(id);
	}
	
	
	/**
	 * 用户激活
	 * @param u
	 * @param uuid
	 * @return
	 */
	public boolean checkIdentity(User u, String uuid) {
		if(u.isUuidRight(uuid)) {
			if(u.isIdentityChanged()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void changeIdentityInfo(User u) {
		u.setIdentity(true);
		this.userMapper.updateByPrimaryKey(u);
	}
	
	/**
	 * 检查用户名是否已经存在
	 * @param name
	 * @return
	 */
	public boolean checkName(String name) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(name);
		if(this.userMapper.selectByExample(userExample).size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查信箱是否已经注册
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andEmailEqualTo(email);
		if(this.userMapper.selectByExample(userExample).size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource(name="userMapper")
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 检查用户密码是否正确
	 * @param username
	 * @param password
	 */
	public List<User> checkPassword(String username, String password) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> users = this.userMapper.selectByExample(userExample);
		/*if(users.size() == 0) {
			userExample = new UserExample();
			criteria = userExample.createCriteria();
			criteria.andEmailEqualTo(username);
			criteria.andPasswordEqualTo(password);
			users = this.userMapper.selectByExampleWithBLOBs(userExample);
			return users;
		} else {
			return users;
		}*/
		return users;
	}

	/**
	 * 重置密码
	 * @param email
	 * @param uuid
	 */
	public void sendResetPasswordEmail(String email, UUID uuid) {
		new MailSender().sendResetPasswordEmail(uuid, email);
	}

	/**
	 * 修改密码
	 * @param email
	 */
	public boolean changePassword(String email,String password) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> users = this.userMapper.selectByExample(userExample);
		if(users.size() > 0) {
			User u = users.get(0);
			u.setPassword(password);
			this.userMapper.updateByPrimaryKey(u);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param sex
	 * @param industry
	 * @param introduction
	 */
	public void changeInfo(int id, String sex, String industry, String introduction) {
		User u = this.userMapper.selectByPrimaryKey(id);
		if(sex.equals("male")) {
			u.setSex(true);
		} else if (sex.equals("female")) {
			u.setSex(false);
		}
		u.setIndustry(industry);
		u.setIntroduction(introduction);
		this.userMapper.updateByPrimaryKeyWithBLOBs(u);
	}

	/**
	 * 更新用户信息
	 * @param userId
	 * @param sex
	 * @param industry
	 * @param introduction
	 * @return
	 */
	public User updateUserInfo(int userId, String sex, String industry, String introduction) {
		User u = this.userMapper.selectByPrimaryKey(userId);
		if(sex.equals("male")) {
			u.setSex(true);
		} else if (sex.equals("female")) {
			u.setSex(false);
		}
		u.setIndustry(industry);
		u.setIntroduction(introduction);
		this.userMapper.updateByPrimaryKeySelective(u);
		return u;
	}	
	
	public void saveUserCookies(HttpServletResponse response, User u) {
		Cookie cookie = new Cookie("userId", u.getId().toString());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
        response.addCookie(cookie);
        cookie = new Cookie("username", u.getName());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
        response.addCookie(cookie);
	}
	
	public void saveAdminCookies(HttpServletResponse response, User u) {
		Cookie cookie = new Cookie("adminId", u.getId().toString());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
        response.addCookie(cookie);
        cookie = new Cookie("adminname", u.getName());
		cookie.setPath("/");
		cookie.setMaxAge(-1);
        response.addCookie(cookie);
	}
	
	public void saveAdminCookies(HttpServletResponse response) {
		User u = new User();
		u.setName("admin");
		u.setId(-1);
		this.saveAdminCookies(response, u);
	}

	/**
	 * @param page
	 * @return
	 */
	public List<User> getUsersByPage(Page p) {		
		return this.userMapper.selectByPage(p);
	}

	/**
	 * @return
	 */
	public int getUserCount() {
		return this.userMapper.countAllUser();
	}

	/**
	 * @param userId
	 */
	public void deleteUserById(int userId) {
		this.userMapper.deleteByPrimaryKey(userId);
	}

	/**
	 * @param userIdString
	 * @param userNameString
	 * @param userEmailString
	 * @param p 
	 * @return
	 */
	public List<User> search(String userIdString, String userNameString, String userEmailString, Page page) {
		UserSearch userSearch = new UserSearch();
		
		User user = new User();
		if(userIdString != null && !userIdString.equals("")) {
			user.setId(Integer.parseInt(userIdString));
		}
		if(userNameString != null && !userNameString.equals("")) {
			user.setName(userNameString);
		}
		if(userEmailString != null && !userEmailString.equals("")) {
			user.setEmail(userEmailString);
		}
		userSearch.setUser(user);
		userSearch.setPage(page);
		return userMapper.selectByUserSearch(userSearch);
	}

	/**
	 * @param userIdString
	 * @param userNameString
	 * @param userEmailString
	 * @return
	 */
	public int getSearchCount(String userIdString, String userNameString, String userEmailString) {
		User user = new User();
		if(userIdString != null && !userIdString.equals("")) {
			user.setId(Integer.parseInt(userIdString));
		}
		if(userNameString != null && !userNameString.equals("")) {
			user.setName(userNameString);
		}
		if(userEmailString != null && !userEmailString.equals("")) {
			user.setEmail(userEmailString);
		}
		return userMapper.countSearch(user);
	}
}
