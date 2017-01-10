package com.example.shdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

import com.example.shdemo.domain.Ticket;
import com.example.shdemo.domain.Train;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class Tests {

	@Autowired
	ITrainManager trainManager;
	@Autowired
	Train train1;
	@Autowired
	Train train2;
	@Autowired
	Train train3;
	@Autowired
	Train train4;
	@Autowired
	Train train5;
	@Autowired
	Train train6;
	@Autowired
	Train train7;
	@Autowired
	Train train8;
	@Autowired
	Train train9;
	@Autowired
	Train train10;
	@Autowired
	Train train11;
	@Autowired
	Train train12;
	//@Autowired
	//Train train13;
	@Autowired
	ITicketManager ticketManager;
	@Autowired
	Ticket ticket1;
	@Autowired
	Ticket ticket2;
	@Autowired
	Ticket ticket3;
	@Autowired
	Ticket ticket4;
	@Autowired
	Ticket ticket5;
	@Autowired
	Ticket ticket6;
	@Autowired
	Ticket ticket7;
	@Autowired
	Ticket ticket8;
	@Autowired
	Ticket ticket9;
	@Autowired
	Ticket ticket10;
	@Autowired
	Ticket ticket11;
	@Test
	public void addTrainCheck(){
		trainManager.addTrain(train1);
		assertEquals(train1, trainManager.getTrain(train1.getIdTrain()));
		trainManager.delTrain(train1);
	}
	
	@Test
	public void updateTrainCheck(){
		trainManager.addTrain(train2);
		train2.setArrivalPoint("Kolobrzeg");
		assertEquals(train2.getArrivalPoint(), trainManager.getTrain(train2.getIdTrain()).getArrivalPoint());
		trainManager.delTrain(train2);
	}
	
	@Test
	public void delTrainChesk(){
		int numBefore = trainManager.getAllTrains().size();
		trainManager.addTrain(train3);
		assertEquals(numBefore + 1, trainManager.getAllTrains().size());
		trainManager.delTrain(train3);
		assertEquals(numBefore, trainManager.getAllTrains().size());
		assertNull(trainManager.getTrain(train3.getTrainNum()));
	}
	
	@Test
	public void getTrainById(){
		trainManager.addTrain(train4);
		Train train = trainManager.getTrain(train4.getIdTrain());
		assertEquals(train, train4);
		trainManager.delTrain(train4);
	}
	
	@Test
	public void getTrainByNumber(){
		trainManager.addTrain(train5);
		Train train = trainManager.getTrain(train5.getTrainNum());
		assertEquals(train, train5);
		trainManager.delTrain(train5);
	}
	
	@Test
	public void getAllTrainCheck(){
		int numBefore = trainManager.getAllTrains().size();
		trainManager.addTrain(train6);
		trainManager.addTrain(train7);
		assertEquals(numBefore + 2, trainManager.getAllTrains().size());
		trainManager.delTrain(train6);
		trainManager.delTrain(train7);
	}
	
	@Test
	public void addTicketCheck(){
		trainManager.addTrain(train8);
		train8.getTickets().add(ticket1);
		train8.getTickets().add(ticket2);
		ticketManager.addTicket(ticket1);
		ticketManager.addTicket(ticket2);
		assertEquals(2, train8.getTickets().size());
		assertNotNull(ticketManager.getTicket(ticket1.getTicketNum()));
		assertNotNull(ticketManager.getTicket(ticket2.getTicketNum()));
		trainManager.delTrain(train8);
	}
	
	@Test
	public void updateTicketCheck(){
		ticketManager.addTicket(ticket3);
		ticket3.setFirstClassPrice(32.32);
		assertEquals(ticket3.getFirstClassPrice(), ticketManager.getTicket(ticket3.getId()).getFirstClassPrice(), 0.02);
		ticketManager.delTicket(ticket3);
	}

	@Test
	public void delTicketCheck(){
		trainManager.addTrain(train9);
		train9.getTickets().add(ticket4);
		train9.getTickets().add(ticket5);
		ticketManager.addTicket(ticket4);
		ticketManager.addTicket(ticket5);
		assertEquals(2, train9.getTickets().size());
		assertNotNull(ticketManager.getTicket(ticket4.getTicketNum()));
		assertNotNull(ticketManager.getTicket(ticket5.getTicketNum()));
		train9.getTickets().remove(ticket4);
		ticketManager.delTicket(ticket4);
		assertNull(ticketManager.getTicket(ticket4.getTicketNum()));
		assertNotNull(ticketManager.getTicket(ticket5.getTicketNum()));
		trainManager.delTrain(train9);
	}
	
	@Test
	public void getTicketsListCheck(){
		trainManager.addTrain(train10);
		train10.getTickets().add(ticket6);
		train10.getTickets().add(ticket7);
		ticketManager.addTicket(ticket6);
		ticketManager.addTicket(ticket7);
		assertEquals(2, train10.getTickets().size());
		trainManager.delTrain(train10);
	}
	
	@Test
	public void getTicketById(){
		trainManager.addTrain(train11);
		train11.getTickets().add(ticket8);
		ticketManager.addTicket(ticket8);
		Ticket ticket = ticketManager.getTicket(ticket8.getId());
		assertNotNull(ticket);
		assertEquals(ticket, ticketManager.getTicket(ticket8.getId()));
		trainManager.delTrain(train11);
	}
	
	@Test
	public void getAllTicketsCheck(){
		int numBefore = ticketManager.getAllTickets().size();
		ticketManager.addTicket(ticket10);
		ticketManager.addTicket(ticket11);
		assertEquals(numBefore + 2, ticketManager.getAllTickets().size());
		assertTrue(ticketManager.getAllTickets().contains(ticket10));
		assertTrue(ticketManager.getAllTickets().contains(ticket11));
		ticketManager.delTicket(ticket10);
		ticketManager.delTicket(ticket11);
	}

}
