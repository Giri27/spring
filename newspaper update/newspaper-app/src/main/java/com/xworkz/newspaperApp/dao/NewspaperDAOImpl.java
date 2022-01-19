package com.xworkz.newspaperApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.newspaperApp.dto.NewspaperDTO;
import com.xworkz.newspaperApp.entity.NewspaperEntity;

@Repository
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
	public List<NewspaperEntity> getAllNewspaper() {
		System.out.println("Invoked getAllNewspaper");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewspaperEntity.getAllNewspaper");
			List<NewspaperEntity> list = query.list();
			if(!list.isEmpty() && list != null) {
				return list;
			} else {
				System.out.println("Table is empty, enter newspaper details again");
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
	public boolean updateNewspaperEntityByName(NewspaperDTO newspaperDTO) {
		System.out.println("Invoked updateNewspaperEntityByName()");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("NewspaperEntity.updateNewspaperEntity");
			query.setParameter("name", newspaperDTO.getNewspaperName());
			query.setParameter("price", newspaperDTO.getPrice());
			query.setParameter("lang", newspaperDTO.getLanguage());
			query.setParameter("pages", newspaperDTO.getNoOfPages());
			
			/*NewspaperEntity entity = (NewspaperEntity) query.uniqueResult(); 
			System.out.println("Found newspaperName "+entity);
			if(entity != null) {
				session.beginTransaction();
				session.update(entity);
				session.getTransaction().commit();
				return true;
			} else {
				System.out.println("Not updated");
				return false;
			}*/
			
			int updated = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Newspaper details updated" +updated);
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
	public boolean deleteNewspaperEntity(String newspaperName) {
		System.out.println("Invoked deleteNewspaperEntity");
		Session session = null;
		/*try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewspaperEntity.deleteNewspaperEntity");
			query.setParameter("name", newspaperName);
			NewspaperEntity object = (NewspaperEntity) query.uniqueResult();  
			System.out.println("Found newspaperName "+object);
			session.beginTransaction();
			session.delete(object);			
			session.getTransaction().commit();
			return true;
		}*/
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewspaperEntity.getNewspaperObject");
			query.setParameter("name", newspaperName);
			NewspaperEntity entity = (NewspaperEntity) query.uniqueResult(); 
			System.out.println("Found newspaperName "+entity);
			if(entity != null) {
				session.beginTransaction();
				session.delete(entity);
				session.getTransaction().commit();
				return true;
			} else {
				System.out.println("Not deleted");
				return false;
			}
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

	/*@Override
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
	}*/
}
