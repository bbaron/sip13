package com.springinpractice.ch15.helpdesk.model;

import java.util.Date;

/**
 * Ticket domain object.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class Ticket {
	private Long id;
	private String custName;
	private String custEmail;
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
	 * @return customer name
	 */
	public String getCustomerName() { return custName; }
	
	/**
	 * @param custName customer name
	 */
	public void setCustomerName(String custName) { this.custName = custName; }

	/**
	 * @return customer e-mail address
	 */
	public String getCustomerEmail() { return custEmail; }

	/**
	 * @param custEmail customer e-mail address
	 */
	public void setCustomerEmail(String custEmail) { this.custEmail = custEmail; }

	/**
	 * @return description
	 */
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
		return "[Ticket: customerName=" + custName
			+ ", customerEmail=" + custEmail
			+ ", description=" + description
			+ ", dateCreated=" + dateCreated
			+ "]";
	}
}
