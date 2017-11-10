/**
 * 
 */
package com.mo1451.mail;

import java.util.UUID;

import junit.framework.TestCase;

/**
 * @author 默1451
 *
 */
public class MailSenderTest extends TestCase {
	private UUID uuid = UUID.randomUUID();
	/**
	 * Test method for {@link com.mo1451.mail.MailSender#sendMail()}.
	 */
	public void testSendMail() {
		new MailSender().sendMail(uuid,1);
	}

}
