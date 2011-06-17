/* 
 * $Id: TicketService.java 31 2011-06-01 04:42:18Z  $
 * 
 * Copyright (c) 2008-2011 Manning Publications Co.
 * 
 * Book web site   - http://www.manning.com/wheeler/
 * Book blog       - http://springinpractice.com/
 * Author web site - http://wheelersoftware.com/
 */
package com.springinpractice.ch15.helpdesk.service;

import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Ticket service interface.
 * 
 * @version $Id: TicketService.java 31 2011-06-01 04:42:18Z  $
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface TicketService {
	
	/**
	 * @param ticket ticket
	 */
	void createTicket(Ticket ticket);
}
