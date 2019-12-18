package com.iris.UserDaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iris.daos.UserDao;
import com.iris.model.User;
import com.iris.utility.SessionFactoryProvider;

public class UserDaoImpl implements UserDao {

	SessionFactory sf=SessionFactoryProvider.getSessionFactory();
	public boolean saveUser(User uobj) {
		try {
			
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			session.save(uobj);
			tx.commit();
			session.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
