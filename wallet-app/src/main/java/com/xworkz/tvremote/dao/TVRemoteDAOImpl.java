package com.xworkz.tvremote.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.tvremote.entity.TVRemote;

@Component
public class TVRemoteDAOImpl implements TVRemoteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addTVRemoteEntity(TVRemote tvRemote) {
		System.out.println("Invoked addTVRemoteEntity");
		Session session= null;
		try {
			//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(tvRemote);
			session.getTransaction();
			System.out.println("tvRemote is saved");
			
		} catch (HibernateException e) {
			System.out.println("Transaction failed... rolling back!");
			session.getTransaction().rollback();
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

}
