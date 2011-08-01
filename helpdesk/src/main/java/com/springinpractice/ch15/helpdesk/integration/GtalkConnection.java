package com.springinpractice.ch15.helpdesk.integration;

import javax.net.SocketFactory;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Configuration
public class GtalkConnection {
	private static final String HOST = "talk.google.com";
	private static final int PORT = 5222;
	private static final String SERVICE_NAME = "gmail.com";
	private static final String RESOURCE = "Ticketing Service";
	
	private String username;
	private String password;
	
	/**
	 * @param username username
	 */
	public void setUsername(String username) { this.username = username; }
	
	/**
	 * @param password password
	 */
	public void setPassword(String password) { this.password = password; }
	
	/**
	 * @return XMPP connection
	 */
	@Bean
	public XMPPConnection xmppConnection() {
		SASLAuthentication.supportSASLMechanism("PLAIN", 0);
		
		ConnectionConfiguration conf = new ConnectionConfiguration(HOST, PORT, SERVICE_NAME);
		conf.setSocketFactory(SocketFactory.getDefault());
		conf.setSecurityMode(SecurityMode.enabled);
		conf.setSASLAuthenticationEnabled(false);
		
		XMPPConnection conn = new XMPPConnection(conf);
		try {
			conn.connect();
			conn.login(username, password, RESOURCE);
		} catch (XMPPException e) {
			throw new RuntimeException(e);
		}
		
		return conn;
	}
}
