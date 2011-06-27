package com.springinpractice.ch15.helpdesk.web;

import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springinpractice.ch15.helpdesk.dao.TicketDao;
import com.springinpractice.ch15.helpdesk.integration.TicketGateway;
import com.springinpractice.ch15.helpdesk.model.Ticket;

/**
 * Web controller for help desk tickets.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Controller
public class TicketController {
	private static final String VN_TICKET_LIST = "tickets/ticketList";
	private static final String VN_NEW_TICKET_FORM = "tickets/newTicketForm";
	private static final String VN_NEW_TICKET_CREATED = "redirect:/tickets/ticketcreated.html";
	private static final String VN_NEW_TICKET_SUCCESS = "tickets/newTicketSuccess";
	private static final Logger LOG = LoggerFactory.getLogger(TicketController.class);
	
	@Inject private TicketDao ticketDao;
	@Inject private TicketGateway ticketGateway;

	/**
	 * @param binder binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	/**
	 * Displays the ticket list page.
	 * 
	 * @param model model
	 * @return logical view name
	 */
	@RequestMapping(value = "/tickets.html", method = RequestMethod.GET)
	public String getTicketList(Model model) {
		model.addAttribute(ticketDao.getAll());
		return VN_TICKET_LIST;
	}
	
	/**
	 * Displays the new ticket entry form.
	 * 
	 * @param model model
	 * @return logical view name
	 */
	@RequestMapping(value = "/tickets/new", method = RequestMethod.GET)
	public String getNewTicketForm(Model model) {
		model.addAttribute(new Ticket());
		return VN_NEW_TICKET_FORM;
	}
	
	/**
	 * Handler method for creating new tickets using an HTML form.
	 * 
	 * @param ticket ticket
	 * @param result result
	 * @return logical view name
	 */
	@RequestMapping(value = "/tickets.html", method = RequestMethod.POST)
	public String createTicket(@ModelAttribute @Valid Ticket ticket, BindingResult result) {
		LOG.debug("Creating ticket: {}", ticket);
		if (result.hasErrors()) { return VN_NEW_TICKET_FORM; }
		ticket.setDateCreated(new Date());
		ticketGateway.createTicket(ticket);
		return VN_NEW_TICKET_CREATED;
	}
	
	/**
	 * Displays a success page following the creation of a new ticket.
	 * 
	 * @return logical view name
	 */
	@RequestMapping(value = "/tickets/ticketcreated", method = RequestMethod.GET)
	public String getSuccessPage() {
		return VN_NEW_TICKET_SUCCESS;
	}
}
