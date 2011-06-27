package com.springinpractice.ch15.helpdesk.integration;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;

import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Transforms e-mail messages into tickets.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class MailToTicketTransformer {
	private static final Logger LOG = LoggerFactory.getLogger(MailToTicketTransformer.class);
	
	/**
	 * @param email e-mail
	 * @return ticket
	 */
	@Transformer
	public Ticket transform(MimeMessage email) {
		LOG.info("Transforming MimeMessage to Ticket");
		try {
			InternetAddress from = (InternetAddress) email.getFrom()[0];
			
			// Create the ticket using the e-mail
			Ticket ticket = new Ticket();
			ticket.setUserName(from.getPersonal());
			ticket.setUserEmail(from.getAddress());
			
			String subj = email.getSubject();
			
			// FIXME This is no good if the e-mail content is a MimeMultipart. The output ends up looking like this:
			// javax.mail.internet.MimeMultipart@598d00
			String content = email.getContent().toString();
			
			ticket.setDescription(subj + "\n\n" + content);
			ticket.setDateCreated(email.getSentDate());
			
			LOG.info("Transformed message {} to ticket {}", email, ticket);
			
			return ticket;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
