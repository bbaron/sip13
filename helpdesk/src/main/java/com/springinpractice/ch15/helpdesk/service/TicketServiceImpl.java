/* 
 * $Id$
 * 
 * Copyright (c) 2008-2011 Manning Publications Co.
 * 
 * Book web site   - http://www.manning.com/wheeler/
 * Book blog       - http://springinpractice.com/
 * Author web site - http://wheelersoftware.com/
 */
package com.springinpractice.ch15.helpdesk.service;

import static org.springframework.util.Assert.notNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Ticket service implementation.
 * 
 * @version $Id$
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.springinpractice.ch15.helpdesk.service.TicketService#createTicket(com.springinpractice.ch15.helpdesk.model.Ticket)
	 */
	@Override
	public void createTicket(Ticket ticket) {
		notNull(ticket);
		LOG.info("Creating ticket: {}", ticket);

		// Save ticket to database here...
	}
}
