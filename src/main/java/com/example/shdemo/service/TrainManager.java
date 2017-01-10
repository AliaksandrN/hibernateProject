package com.example.shdemo.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Train;

@Component
@Transactional
public class TrainManager implements ITrainManager {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTrain(Train train) {
		this.sessionFactory.getCurrentSession().persist(train);
	}

	@Override
	public void delTrain(Train train) {
		train = (Train) this.sessionFactory.getCurrentSession().get(Train.class, train.getIdTrain());
		this.sessionFactory.getCurrentSession().delete(train);
	}

	@Override
	public Train getTrain(long id) {
		return (Train) this.sessionFactory.getCurrentSession().get(Train.class, id);
	}

	@Override
	public Train getTrain(String trainNum) {
		return (Train) this.sessionFactory.getCurrentSession().getNamedQuery("train.byNum").setString("trainNum", trainNum).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Train> getAllTrains() {
		return this.sessionFactory.getCurrentSession().getNamedQuery("train.all").list();
	}


}
