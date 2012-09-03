package com.springinpractice.ch13.portal.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@XmlRootElement(name = "ticket")
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class PortalTicket {
	private String userName;
	private String userEmail;
	private String description;
	private Date dateCreated;
	
	@NotNull
	@Size(min = 1, max = 80)
	public String getUserName() { return userName; }
	
	public void setUserName(String name) { this.userName = name; }
	
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	public String getUserEmail() { return userEmail; }
	
	public void setUserEmail(String email) { this.userEmail = email; }
	
	@NotNull
	@Size(min = 1, max = 4000)
	public String getDescription() { return description; }
	
	public void setDescription(String desc) { this.description = desc; }
	
	public Date getDateCreated() { return dateCreated; }
	
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
	
	@Override
	public String toString() {
		return "[PortalTicket: userName=" + userName
			+ ", userEmail=" + userEmail
			+ ", description=" + description
			+ ", dateCreated=" + dateCreated
			+ "]";
	}
}
