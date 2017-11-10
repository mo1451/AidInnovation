/**
 * 
 */
package com.mo1451.mail;

import com.mo1451.model.User;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author 默1451
 *
 */
public class MailSender {

	private String comName = "辅助创新";
	
	/**
	 * 发送激活邮件
	 * @param uuid
	 * @param user
	 */
	public void sendMail(UUID uuid,User user) {
		int id = user.getId();
		Properties props = System.getProperties();
		//设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.163.com");
		//设置服务器需要身份认真
		props.setProperty("mail.stmp.auth", "true");
		// 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  		
          
        // 设置环境信息  
        Session session = Session.getInstance(props);  
          
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        String url = "http://localhost:8765/AidInnovation/identity?uuid=";
        
        
        try {
        	
        	// 设置邮件内容  
        	msg.setSubject("请激活你的帐号，完成注册");  
			msg.setText("欢迎加入" + comName + "!\n\n"
					+ "请点击下面的链接完成注册：\n\n" 
					+ url 
					+ uuid + "&id=" + id + "\n\n\n"
					+ "如果以上链接无法点击，请将上面的地址复制到你的浏览器(如IE)的地址栏进入\n\n"					
					+ "--" + comName + "\n\n"
					+ "(这是一封自动产生的email，请勿回复。)\n\n"
					);
			// 设置发件人  
	        msg.setFrom(new InternetAddress("innovation32@163.com"));  	
	        
	        Transport transport = session.getTransport();  
	        // 连接邮件服务器  
	        transport.connect("innovation32", "innovation123");  
	        // 发送邮件  
	        transport.sendMessage(msg, new Address[] {new InternetAddress(user.getEmail())});
	        // 关闭连接  
	        transport.close();  
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}
	
	/**
	 * 发送改变密码邮件
	 * @param uuid
	 * @param email
	 */
	public void resetPassword(UUID uuid,String email) {
		Properties props = System.getProperties();
		//设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.163.com");
		//设置服务器需要身份认真
		props.setProperty("mail.stmp.auth", "true");
		// 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  		
          
        // 设置环境信息  
        Session session = Session.getInstance(props);  
          
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        
        String url = "http://localhost:8765/AidInnovation/resetPassword?uuid=";
        
        
        try {
        	
        	// 设置邮件内容  
        	msg.setSubject("重设密码");  
			msg.setText("亲爱的用户" + "：\n\n"
					+ "你的密码重设要求已经得到验证。请点击以下链接输入你新的密码：\n\n" 
					+ url + uuid + "&email=" + email + "\n\n\n"
					+ "如果以上链接无法点击，请将上面的地址复制到你的浏览器(如IE)的地址栏进入\n\n"					
					+ "--" + comName + "\n\n"
					+ "(这是一封自动产生的email，请勿回复。)\n\n");
			System.out.println(url + uuid + "&email=" + email);
			// 设置发件人  
	        msg.setFrom(new InternetAddress("innovation32@163.com"));  	
	        
	        Transport transport = session.getTransport();  
	        // 连接邮件服务器  
	        transport.connect("innovation32", "innovation123");  
	        // 发送邮件  
	        transport.sendMessage(msg, new Address[] {new InternetAddress(email)});  
	        // 关闭连接  
	        transport.close();  
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}
}
