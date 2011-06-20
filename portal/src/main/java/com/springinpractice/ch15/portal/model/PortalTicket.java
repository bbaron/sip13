package com.springinpractice.ch15.portal.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class PortalTicket {
	private String userName;
	private String userEmail;
	private String description;
	private Date dateCreated;
	
	/**
	 * @return userName
	 */
	@NotNull
	@Size(min = 1, max = 80)
	public String getUserName() { return userName; }
	
	/**
	 * @param userName user name
	 */
	public void setUserName(String name) { this.userName = name; }
	
	/**
	 * @return e-mail
	 */
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	public String getUserEmail() { return userEmail; }
	
	/**
	 * @param userEmail e-mail
	 */
	public void setUserEmail(String email) { this.userEmail = email; }
	
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
		return "[PortalTicket: userName=" + userName
			+ ", userEmail=" + userEmail
			+ ", description=" + description
			+ ", dateCreated=" + dateCreated
			+ "]";
	}
}
