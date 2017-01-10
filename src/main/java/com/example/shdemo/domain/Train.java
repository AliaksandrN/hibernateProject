package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "train.all", query = "SELECT t FROM Train t"),
	@NamedQuery(name = "train.byNum", query = "SELECT t FROM Train t WHERE t.trainNum = :trainNum")
})
public class Train {
	private long idTrain;
	private String trainNum;
	private String departurePoint;
	private String arrivalPoint;
	
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public Train(){}
	
	public Train(String trainNum, String departurePoint, String arrivalPoint){
		super();
		this.trainNum = trainNum;
		this.departurePoint = departurePoint;
		this.arrivalPoint = arrivalPoint;
	}
	
	public Train(long idTrain, String trainNum, String departurePoint, String arrivalPoint){
		super();
		this.idTrain = idTrain;
		this.trainNum = trainNum;
		this.departurePoint = departurePoint;
		this.arrivalPoint = arrivalPoint;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdTrain() {
		return idTrain;
	}
	
	public void setIdTrain(long idTrain) {
		this.idTrain = idTrain;
	}
	public String getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}
	public String getDeparturePoint() {
		return departurePoint;
	}
	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}
	public String getArrivalPoint() {
		return arrivalPoint;
	}
	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
