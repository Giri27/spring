package com.xworkz.newspaperApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.newspaperApp.entity.NewspaperEntity;

@Component
public class NewspaperDAOImpl implements NewspaperDAO {

	@Autowired
	private SessionFactory factory;
	
	public NewspaperDAOImpl() {
		System.out.println(this.getClass().getSimpleName() +"created");
	}
	
	@Override
	public boolean saveNewspaperEntity(NewspaperEntity newspaperEntity) {
		System.out.println("Invoked saveNewspaperEntity");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(newspaperEntity);
			session.getTransaction().commit();
			System.out.println("NewspaperEntity is saved");
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Transaction is rolledback");
		} finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return false;
	}

}
