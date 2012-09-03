package com.springinpractice.ch13.helpdesk.web;

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

import com.springinpractice.ch13.helpdesk.dao.TicketDao;
import com.springinpractice.ch13.helpdesk.integration.TicketGateway;
import com.springinpractice.ch13.helpdesk.model.Ticket;

/**
 * Web controller for help desk tickets.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Controller
@RequestMapping("/tickets")
public class TicketController {
	private static final Logger log = LoggerFactory.getLogger(TicketController.class);
	
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
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getTicketList(Model model) {
		model.addAttribute(ticketDao.findAll());
		return "tickets/ticketList";
	}
	
	/**
	 * Displays the new ticket entry form.
	 * 
	 * @param model model
	 * @return logical view name
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNewTicketForm(Model model) {
		model.addAttribute(new Ticket());
		return "tickets/newTicketForm";
	}
	
	/**
	 * Processes new ticket submissions.
	 * 
	 * @param ticket ticket
	 * @param result result
	 * @return logical view name
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createTicket(@ModelAttribute @Valid Ticket ticket, BindingResult result) {
		log.debug("Creating ticket: {}", ticket);
		
		if (result.hasErrors()) {
			return "tickets/newTicketForm";
		}
		
		ticket.setDateCreated(new Date());
		ticketGateway.createTicket(ticket);
		return "redirect:/tickets/ticketcreated.html";
	}
	
	/**
	 * Displays a success page following the creation of a new ticket.
	 * 
	 * @return logical view name
	 */
	@RequestMapping(value = "/ticketcreated", method = RequestMethod.GET)
	public String getSuccessPage() {
		return "tickets/newTicketSuccess";
	}
}
