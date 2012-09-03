package com.springinpractice.ch13.portal.service.impl;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Service;

import com.springinpractice.ch13.portal.model.PortalTicket;
import com.springinpractice.ch13.portal.service.PortalTicketService;

/**
 * Portal service bean.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service
public class PortalTicketServiceImpl implements PortalTicketService {

	@Override
	public void createTicket(PortalTicket ticket) {
		notNull(ticket, "ticket can't be null");
		
		// TODO Will be sending the ticket to the Help Desk app.
	}
}
