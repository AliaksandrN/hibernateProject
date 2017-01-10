package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Ticket;

public interface ITicketManager {
	
	public void addTicket(Ticket ticket);
	public void delTicket(Ticket ticket);
	public Ticket getTicket(long id);
	public Ticket getTicket(String numTicket);
	public List<Ticket> getAllTickets();
}
