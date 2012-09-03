package com.springinpractice.ch13.portal.web;

import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.springinpractice.ch13.portal.model.PortalTicket;
import com.springinpractice.ch13.portal.service.PortalTicketService;

@Controller
@RequestMapping("/tickets")
public class PortalTicketController {
	private static final Logger log = LoggerFactory.getLogger(PortalTicketController.class);
	
	@Inject private PortalTicketService portalService;
	@Inject private RestTemplate restTemplate;
	
	@Value("#{portalProps.helpDeskNewTicketUrl}")
	private String helpDeskNewTicketUrl;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNewTicketForm(Model model) {
		model.addAttribute("ticket", new PortalTicket());
		return "tickets/newTicketForm";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createTicket(@ModelAttribute("ticket") @Valid PortalTicket ticket, BindingResult result) {
		log.debug("Creating ticket: {}", ticket);
		
		if (result.hasErrors()) {
			return "tickets/newTicketForm";
		}
		
		ticket.setDateCreated(new Date());
		portalService.createTicket(ticket);
		
		// This marshalls the ticket into XML using JAXB and puts it in the request body.
		restTemplate.postForLocation(helpDeskNewTicketUrl, ticket);
		
		return "redirect:/tickets/ticketcreated.html";
	}
	
	@RequestMapping(value = "/ticketcreated", method = RequestMethod.GET)
	public String getSuccessPage() {
		return "tickets/newTicketSuccess";
	}
}
