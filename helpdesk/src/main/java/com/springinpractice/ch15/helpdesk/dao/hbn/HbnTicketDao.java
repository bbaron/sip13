package com.springinpractice.ch15.helpdesk.dao.hbn;

import org.springframework.stereotype.Repository;

import com.springinpractice.ch15.helpdesk.dao.TicketDao;
import com.springinpractice.ch15.helpdesk.model.Ticket;
import com.springinpractice.dao.hibernate.AbstractHbnDao;

/**
 * Hibernate ticket DAO implementation.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Repository
public class HbnTicketDao extends AbstractHbnDao<Ticket> implements TicketDao {
}
