package com.springinpractice.ch13.helpdesk.service.impl;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springinpractice.ch13.helpdesk.dao.TicketDao;
import com.springinpractice.ch13.helpdesk.model.Ticket;
import com.springinpractice.ch13.helpdesk.service.TicketService;

/**
 * Ticket service implementation.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	private static final Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);
	
	@Inject private TicketDao ticketDao;
	
	@Override
	public void createTicket(Ticket ticket) {
		notNull(ticket);
		log.info("Creating ticket: {}", ticket);
		ticketDao.save(ticket);
	}
}
