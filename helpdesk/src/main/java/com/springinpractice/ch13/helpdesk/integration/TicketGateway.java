package com.springinpractice.ch13.helpdesk.integration;

import org.springframework.integration.annotation.Gateway;

import com.springinpractice.ch13.helpdesk.model.Ticket;

/**
 * Ticket gateway to support integration between the help desk app and the message bus.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface TicketGateway {
	
	/**
	 * Pushes newly-created tickets onto the new ticket channel.
	 * 
	 * @param ticket ticket
	 */
	@Gateway(requestChannel = "newTicketChannel")
	void createTicket(Ticket ticket);
}
