package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ticket.all", query = "SELECT t FROM Ticket t"),
	@NamedQuery(name = "ticket.byNum", query = "SELECT ti FROM Ticket ti WHERE ti.ticketNum = :ticketNum")
})
public class Ticket {

	private long id;
	private String ticketNum;
	private double firstClassPrice;
	private double secondClassPrice;
	
	public Ticket() {
	}

	public Ticket(String ticketNum, double firstClassPrice, double secondClassPrice) {
		super();
		this.ticketNum = ticketNum;
		this.firstClassPrice = firstClassPrice;
		this.secondClassPrice = secondClassPrice;
	}
	public Ticket(long id, double firstClassPrice, double secondClassPrice) {
		super();
		this.id = id;
		this.firstClassPrice = firstClassPrice;
		this.secondClassPrice = secondClassPrice;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public double getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(double firstClassPrice) {
		this.firstClassPrice = firstClassPrice;
	}
	public double getSecondClassPrice() {
		return secondClassPrice;
	}
	public void setSecondClassPrice(double secondClassPrice) {
		this.secondClassPrice = secondClassPrice;
	}

}
