package com.springinpractice.ch15.portal.web;

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

import com.springinpractice.ch15.portal.model.PortalTicket;
import com.springinpractice.ch15.portal.service.PortalTicketService;

@Controller
@RequestMapping("/tickets")
public class PortalTicketController {
	private static final String VN_NEW_TICKET_FORM = "tickets/newTicketForm";
	private static final String VN_NEW_TICKET_CREATED = "redirect:/tickets/ticketcreated.html";
	private static final String VN_NEW_TICKET_SUCCESS = "tickets/newTicketSuccess";
	private static final Logger LOG = LoggerFactory.getLogger(PortalTicketController.class);
	
	@Inject private PortalTicketService portalService;

	/**
	 * @param binder binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	/**
	 * @param model model
	 * @return logical view name
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNewTicketForm(Model model) {
		model.addAttribute("ticket", new PortalTicket());
		return VN_NEW_TICKET_FORM;
	}
	
	/**
	 * @param ticket ticket
	 * @return logical view name
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createTicket(@ModelAttribute("ticket") @Valid PortalTicket ticket, BindingResult result) {
		LOG.debug("Creating ticket: {}", ticket);
		if (result.hasErrors()) { return VN_NEW_TICKET_FORM; }
		ticket.setDateCreated(new Date());
		portalService.createTicket(ticket);
		return VN_NEW_TICKET_CREATED;
	}
	
	/**
	 * @return logical view name
	 */
	@RequestMapping(value = "/ticketcreated", method = RequestMethod.GET)
	public String getSuccessPage() {
		return VN_NEW_TICKET_SUCCESS;
	}
}
