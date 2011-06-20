package com.springinpractice.ch15.portal.service;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
	
	@Inject private RestTemplate restTemplate;
	
	/**
	 * HTTP endpoint to receive tickets created by this service in <code>application/x-www-form-urlencoded</code> format
	 * (i.e., just normal HTTP form posts). We intend this to be an endpoint on the ticketing message bus, rather than
	 * posting directly to a web form processing URL.
	 * 
	 * @param url URL
	 */
	@Value("#{portalProps.helpDeskNewTicketUrl}")
	private String helpDeskNewTicketUrl;

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
		LOG.debug("POSTing application/x-www-form-urlencoded portal ticket {} to ticketing service at {}",
				ticket, helpDeskNewTicketUrl);
		
		MultiValueMap<String, String> ticketData = new LinkedMultiValueMap<String, String>();
		ticketData.add("userName", ticket.getUserName());
		ticketData.add("userEmail", ticket.getUserEmail());
		ticketData.add("description", ticket.getDescription());
		restTemplate.postForLocation(helpDeskNewTicketUrl, ticketData);
	}
}
