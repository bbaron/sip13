package com.springinpractice.ch15.portal.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class PortalTicket {
	private String name;
	private String email;
	private String description;
	private Date dateCreated;
	
	/**
	 * @return name
	 */
	@NotNull
	@Size(min = 1, max = 80)
	public String getName() { return name; }
	
	/**
	 * @param name name
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * @return e-mail
	 */
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	public String getEmail() { return email; }
	
	/**
	 * @param email e-mail
	 */
	public void setEmail(String email) { this.email = email; }
	
	/**
	 * @return description
	 */
	@NotNull
	@Size(min = 1, max = 4000)
	public String getDescription() { return description; }
	
	/**
	 * @param description description
	 */
	public void setDescription(String desc) { this.description = desc; }
	
	/**
	 * @return date created
	 */
	public Date getDateCreated() { return dateCreated; }
	
	/**
	 * @param dateCreated date created
	 */
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[PortalTicket: name=" + name
			+ ", email=" + email
			+ ", description=" + description
			+ ", dateCreated=" + dateCreated
			+ "]";
	}
}
