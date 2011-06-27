package com.springinpractice.ch15.helpdesk.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;

import com.springinpractice.ch15.helpdesk.model.BasecampTodoItem;
import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class TicketToBasecampTodoItemTransformer {
	private static final Logger LOG = LoggerFactory.getLogger(TicketToBasecampTodoItemTransformer.class);
	
	/**
	 * Transforms a ticket into a Basecamp to-do item.
	 * 
	 * @param ticket ticket
	 * @return Basecamp to-do item
	 */
	@Transformer
	public BasecampTodoItem transform(Ticket ticket) {
		BasecampTodoItem item = new BasecampTodoItem();
		item.setContent(ticket.getDescription());
		LOG.debug("Transforming ticket {} into Basecamp to-do item {}", ticket, item);
		return item;
	}
}
