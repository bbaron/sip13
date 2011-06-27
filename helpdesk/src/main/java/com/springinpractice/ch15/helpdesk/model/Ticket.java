package com.springinpractice.ch15.helpdesk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

/**
 * Ticket domain object.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.NONE)
@Entity
@Table(name = "ticket")
public class Ticket {
	private Long id;
	private String userName;
	private String userEmail;
	private String description;
	private Date dateCreated;
	
	/**
	 * @return ID
	 */
	@XmlAttribute
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() { return id; }
	
	/**
	 * @param id ID
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }

	/**
	 * @return user name
	 */
	@XmlElement
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "user_name")
	public String getUserName() { return userName; }
	
	/**
	 * @param name user name
	 */
	public void setUserName(String name) { this.userName = name; }

	/**
	 * @return user e-mail address
	 */
	@XmlElement
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	@Column(name = "user_email")
	public String getUserEmail() { return userEmail; }

	/**
	 * @param email user e-mail address
	 */
	public void setUserEmail(String email) { this.userEmail = email; }

	/**
	 * @return description
	 */
	@XmlElement
	@NotNull
	@Size(min = 1, max = 4000)
	@Column(name = "description")
	public String getDescription() { return description; }

	/**
	 * @param desc description
	 */
	public void setDescription(String desc) { this.description = desc; }
	
	/**
	 * @return date created
	 */
	@XmlElement
	@Column(name = "date_created")
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
