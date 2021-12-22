package com.xworkz.bottle.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.bottle.entity.BottleEntity;

@Component
public class BottleDAOImpl implements BottleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public BottleDAOImpl() {
		System.out.println(this.getClass().getSimpleName()+ " bean created");
	}

	@Override
	public void addBottleEntity(BottleEntity bottleEntity) {

		System.out.println("Invoked BottleEntity");
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(bottleEntity);
			session.getTransaction().commit();
			System.out.println("BottleEntity is saved");
			
		} catch (HibernateException e) {
			System.out.println("Transaction failed...rolling back!");
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
