package com.springinpractice.ch15.helpdesk.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Ticket domain object.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class Ticket {
	private Long id;
	private String userName;
	private String userEmail;
	private String description;
	private Date dateCreated;
	
	/**
	 * @return ID
	 */
	public Long getId() { return id; }
	
	/**
	 * @param id ID
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }

	/**
	 * @return user name
	 */
	@NotNull
	@Size(min = 1, max = 80)
	public String getUserName() { return userName; }
	
	/**
	 * @param name user name
	 */
	public void setUserName(String name) { this.userName = name; }

	/**
	 * @return user e-mail address
	 */
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	public String getUserEmail() { return userEmail; }

	/**
	 * @param email user e-mail address
	 */
	public void setUserEmail(String email) { this.userEmail = email; }

	/**
	 * @return description
	 */
	@NotNull
	@Size(min = 1, max = 4000)
	public String getDescription() { return description; }

	/**
	 * @param desc description
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
		return "[Ticket: userName=" + userName
			+ ", userEmail=" + userEmail
			+ ", description=" + description
			+ ", dateCreated=" + dateCreated
			+ "]";
	}
}
