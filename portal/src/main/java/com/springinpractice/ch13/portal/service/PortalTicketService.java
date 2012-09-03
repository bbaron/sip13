package com.springinpractice.ch13.portal.service;

import com.springinpractice.ch13.portal.model.PortalTicket;

public interface PortalTicketService {
	
	/**
	 * @param ticket ticket
	 */
	void createTicket(PortalTicket ticket);
}
