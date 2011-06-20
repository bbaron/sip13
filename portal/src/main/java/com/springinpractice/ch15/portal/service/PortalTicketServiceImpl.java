package com.springinpractice.ch15.portal.service;

import static org.springframework.util.Assert.notNull;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springinpractice.ch15.portal.model.PortalTicket;

/**
 * Portal service bean. Forwards newly created tickets to a configurable HTTP form endpoint, which is intended to be a
 * message bus.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service
public class PortalTicketServiceImpl implements PortalTicketService {
	private static final Logger LOG = LoggerFactory.getLogger(PortalTicketServiceImpl.class);
	
	private String ticketingServiceUrl;
	
	/**
	 * HTTP endpoint to receive tickets created by this service in <code>application/x-www-form-urlencoded</code> format
	 * (i.e., just normal HTTP form posts). We intend this to be an endpoint on the ticketing message bus, rather than
	 * posting directly to a web form processing URL.
	 * 
	 * @param url URL
	 */
	public void setTicketingServiceUrl(String url) { this.ticketingServiceUrl = url; }

	/* (non-Javadoc)
	 * @see com.springinpractice.ch15.portal.service.PortalTicketService#createTicket(com.springinpractice.ch15.portal.model.PortalTicket)
	 */
	@Override
	public void createTicket(PortalTicket ticket) {
		notNull(ticket, "ticket can't be null");
		saveTicketLocally(ticket);
		sendTicketToTicketingService(ticket);
	}
	
	/**
	 * @param ticket ticket
	 */
	private void saveTicketLocally(PortalTicket ticket) {
		LOG.info("Saving ticket to portal database (simulated)");
		// Save it...
	}
	
	/**
	 * @param ticket ticket
	 */
	private void sendTicketToTicketingService(PortalTicket ticket) {
		LOG.debug("POSTing application/x-www-form-urlencoded portal ticket data to ticketing service");
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(ticketingServiceUrl);
		post.addParameter("userName", ticket.getName());
		post.addParameter("userEmail", ticket.getEmail());
		post.addParameter("issueDescription", ticket.getDescription());
		
		try {
			int statusCode = client.executeMethod(post);
			if (statusCode == HttpStatus.SC_OK) {
				LOG.debug("POST succeeded");
			} else {
				LOG.error("POST failed: {}", post.getStatusLine());
			}
		} catch (IOException e) {
			LOG.error("IOException", e);
			throw new RuntimeException(e);
		} finally {
			post.releaseConnection();
		}
	}
}
