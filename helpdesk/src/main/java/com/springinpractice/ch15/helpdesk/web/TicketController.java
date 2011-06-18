package com.springinpractice.ch15.helpdesk.web;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springinpractice.ch15.helpdesk.integration.TicketGateway;
import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Controller
@RequestMapping("/tickets")
public class TicketController {
	private static final Logger LOG = LoggerFactory.getLogger(TicketController.class);
	
	@Inject private TicketGateway ticketGateway;

	// Normally we'd have an @InitBinder method and do form validation, but not for this simple example.
	
	/**
	 * @param model model
	 * @return logical view name
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNewTicketForm(Model model) {
		model.addAttribute(new Ticket());
		return "tickets/newTicketForm";
	}
	
	/**
	 * @param ticket ticket
	 * @return logical view name
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String createTicket(Ticket ticket) {
		LOG.debug("Creating ticket: {}", ticket);
		ticket.setDateCreated(new Date());
		ticketGateway.createTicket(ticket);
		return "redirect:/tickets/ticketcreated.html";
	}
	
	/**
	 * @return logical view name
	 */
	@RequestMapping(value = "/ticketcreated", method = RequestMethod.GET)
	public String getSuccessPage() {
		return "tickets/newTicketSuccess";
	}
}
