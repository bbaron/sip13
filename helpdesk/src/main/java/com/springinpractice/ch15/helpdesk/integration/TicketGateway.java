/* 
 * $Id$
 * 
 * Copyright (c) 2008-2011 Manning Publications Co.
 * 
 * Book web site   - http://www.manning.com/wheeler/
 * Book blog       - http://springinpractice.com/
 * Author web site - http://wheelersoftware.com/
 */
package com.springinpractice.ch15.helpdesk.integration;

import org.springframework.integration.annotation.Gateway;

import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * @version $Id$
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface TicketGateway {
	
	/**
	 * <p>
	 * Push created tickets onto the new ticket channel.
	 * </p>
	 * 
	 * @param ticket ticket
	 */
	@Gateway(requestChannel = "newTicketChannel")
	void createTicket(Ticket ticket);
}
