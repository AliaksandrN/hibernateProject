package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Train;

public interface ITrainManager {
	
	public void addTrain(Train train);
	public void delTrain(Train train);
	public Train getTrain(long id);
	public Train getTrain(String trainNum);
	public List<Train> getAllTrains();
}
