package com.springinpractice.ch15.portal.model;

import java.util.Date;

public class PortalTicket {
	private String name;
	private String email;
	private String desc;
	private Date dateCreated;
	
	/**
	 * @return name
	 */
	public String getName() { return name; }
	
	/**
	 * @param name name
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * @return e-mail
	 */
	public String getEmail() { return email; }
	
	/**
	 * @param email e-mail
	 */
	public void setEmail(String email) { this.email = email; }
	
	/**
	 * @return description
	 */
	public String getDescription() { return desc; }
	
	/**
	 * @param desc description
	 */
	public void setDescription(String desc) { this.desc = desc; }
	
	/**
	 * @return date created
	 */
	public Date getDateCreated() { return dateCreated; }
	
	/**
	 * @param dateCreated date created
	 */
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
}
