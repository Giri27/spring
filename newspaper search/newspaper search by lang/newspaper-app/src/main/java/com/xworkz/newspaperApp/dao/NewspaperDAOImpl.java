package com.xworkz.newspaperApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@Override
	public NewspaperEntity getNewspaperEntity(String newspaperName) {
		System.out.println("Invoked getNewspaperEntity");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewspaperEntity.getNewspaperObject");
			query.setParameter("name", newspaperName);
			NewspaperEntity entity = (NewspaperEntity) query.uniqueResult(); 
			System.out.println("Found newspaperName "+entity);
			if(entity != null) {
				return entity;
			} else {
				System.out.println("Newspaper not found");
				return null;
			}
		} catch (HibernateException e) {
			System.out.println("Catch block..");
		} finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;
	}

	@Override
	public NewspaperEntity getNewspaperEntityByLang(String language) {
		System.out.println("Invoked getNewspaperEntityByLang");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewspaperEntity.getNewspaperObjectForLang");
			query.setParameter("lang", language);
			NewspaperEntity entity = (NewspaperEntity) query.uniqueResult(); 
			System.out.println("Found newspaperLanguage "+entity);
			if(entity != null) {
				return entity;
			} else {
				System.out.println("Newspaper not found");
				return null;
			}
		} catch (HibernateException e) {
			System.out.println("Catch block..");
		} finally {
			if(session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;
	}

}
