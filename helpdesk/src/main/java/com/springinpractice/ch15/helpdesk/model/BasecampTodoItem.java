package com.springinpractice.ch15.helpdesk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@XmlRootElement(name = "todo-item")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "content" })
public class BasecampTodoItem {
	private String content;
	
	/**
	 * @return content
	 */
	@XmlElement(name = "content")
	public String getContent() { return content; }
	
	/**
	 * @param content content
	 */
	public void setContent(String content) { this.content = content; }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[BasecampTodoItem: content=" + content + "]";
	}
}
