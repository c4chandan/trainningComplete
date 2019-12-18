package com.iris.UserDaoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iris.daos.UserDao;
import com.iris.model.Address;
import com.iris.model.User;
import com.iris.utility.SessionFactoryProvider;

public class UserDaoImpl implements UserDao {

	SessionFactory sf = SessionFactoryProvider.getSessionFactory();

	public boolean registerCustomer(User cust) {
		try {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			cust.setRole("customer");
			session.save(cust);
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public User validateCustomers(String userName, String Password) {
		try {
			Session session = sf.openSession();

			Query<User> query=session.createQuery("from com.iris.model.User where userName=:x and Password=:y");
			query.setParameter("x", userName);
			query.setParameter("y", Password);
			List<User> userobj = query.list();
			if(userobj==null) {
				session.close();
		
			}
			else {
				if(userobj.size()!=0)
				{
					session.close();
					return userobj.get(0);
				}
			}
			

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		
	}

	public List<User> viewAllCustomers() {

		try {

				Session session = sf.openSession();
				Query<User> query=session.createQuery("from com.iris.model.User where role=:role");
				query.setParameter("role", "customer");
			List<User> userList = query.list();
						session.close();
						return userList;
						
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteCustomer(int id) {
		try {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			User obj = session.get(User.class, id);

			if (obj == null) {
				return false;
			} else {
				session.delete(obj);
			}
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public User updateCustomers(User cust) {
		try {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.update(cust);
			tx.commit();
			session.close();
			return cust;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public User getCustomers(int id) {
		
		try {
		Session session = sf.openSession();
		User obj = session.get(User.class, id);
		session.close();
		return obj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> ViewAddress(Address  a) {
		return null;
//		try {
//
//			Session session = sf.openSession();
//			Query<User> query=session.createQuery("from com.iris.model.Address where userId=:x");
//			
//		List<User> userList = query.list();
//					session.close();
//					return userList;
//					
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//	return null;
	}



}
