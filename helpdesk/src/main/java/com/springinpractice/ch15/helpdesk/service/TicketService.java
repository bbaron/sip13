package com.springinpractice.ch15.helpdesk.service;

import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Ticket service interface.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface TicketService {
	
	/**
	 * @param ticket ticket
	 */
	void createTicket(Ticket ticket);
}
