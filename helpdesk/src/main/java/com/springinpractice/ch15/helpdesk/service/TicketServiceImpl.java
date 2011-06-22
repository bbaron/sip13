package com.springinpractice.ch15.helpdesk.service;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springinpractice.ch15.helpdesk.dao.TicketDao;
import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Ticket service implementation.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);
	
	@Inject private TicketDao ticketDao;
	
	/* (non-Javadoc)
	 * @see com.springinpractice.ch15.helpdesk.service.TicketService#createTicket(
	 * com.springinpractice.ch15.helpdesk.model.Ticket)
	 */
	@Override
	public void createTicket(Ticket ticket) {
		notNull(ticket);
		LOG.info("Creating ticket: {}", ticket);
		ticketDao.create(ticket);
	}
}
