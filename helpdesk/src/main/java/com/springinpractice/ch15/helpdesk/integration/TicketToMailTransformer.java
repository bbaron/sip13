package com.springinpractice.ch15.helpdesk.integration;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;

import com.springinpractice.ch13.helpdesk.model.Ticket;

/**
 * Maps the ticket to a confirmation e-mail.
 */
public class TicketToMailTransformer {
	private static final Logger LOG = LoggerFactory.getLogger(TicketToMailTransformer.class);
	
	private String confFrom;
	private String confSubj;
	
	/**
	 * @return value of the confirmation e-mail "from" field
	 */
	public String getConfirmationFrom() { return confFrom; }
	
	/**
	 * @param confFrom value of the confirmation e-mail "from" field
	 */
	public void setConfirmationFrom(String confFrom) { this.confFrom = confFrom; }
	
	/**
	 * @return value of the confirmation e-mail "subject" field
	 */
	public String getConfirmationSubject() { return confSubj; }
	
	/**
	 * @param confSubj value of the confirmation e-mail "subject" field
	 */
	public void setConfirmationSubject(String confSubj) { this.confSubj = confSubj; }
	
	/**
	 * @param ticket ticket
	 * @return e-mail message
	 */
	@Transformer
	public MailMessage transform(Ticket ticket) {
		MailMessage msg = new SimpleMailMessage();
		
		String userName = ticket.getUserName();
		String userEmail = ticket.getUserEmail();
		msg.setTo(userName + " <" + userEmail + ">");
		
		msg.setFrom(confFrom);
		msg.setSubject(confSubj);
		msg.setSentDate(new Date());
		String desc = "Thank you for reporting this issue. We will contact you shortly.\n\n"
			+ "Your message:\n\n"
			+ ticket.getDescription();
		msg.setText(desc);
		
		LOG.info("Transformed ticket {} to e-mail {}", ticket, msg);
		
		return msg;
	}
}
