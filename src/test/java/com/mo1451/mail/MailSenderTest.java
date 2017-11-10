/**
 * 
 */
package com.mo1451.mail;

import java.util.UUID;

import com.mo1451.model.User;
import junit.framework.TestCase;

/**
 * @author 默1451
 *
 */
public class MailSenderTest extends TestCase {
	private UUID uuid = UUID.randomUUID();

	public void testSendMail() {
		new MailSender().sendMail(uuid,new User());
	}

}
