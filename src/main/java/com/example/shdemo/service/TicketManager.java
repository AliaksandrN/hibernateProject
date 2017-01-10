package com.example.shdemo.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Ticket;

@Component
@Transactional
public class TicketManager implements ITicketManager {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTicket(Ticket ticket) {
		this.sessionFactory.getCurrentSession().persist(ticket);		
	}

	@Override
	public void delTicket(Ticket ticket) {
		ticket = (Ticket) this.sessionFactory.getCurrentSession().get(Ticket.class, ticket.getId());
		this.sessionFactory.getCurrentSession().delete(ticket);		
	}

	@Override
	public Ticket getTicket(long id) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(Ticket.class, id);
	}

	@Override
	public Ticket getTicket(String ticketNum) {
		return (Ticket) this.sessionFactory.getCurrentSession().getNamedQuery("ticket.byNum").setString("ticketNum", ticketNum).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getAllTickets() {
		return this.sessionFactory.getCurrentSession().getNamedQuery("ticket.all").list();
	}

}
