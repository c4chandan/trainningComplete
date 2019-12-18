package com.eshop.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.dao.UserDao;
import com.eshop.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(User uobj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			uobj.setRole("customer");
			session.saveOrUpdate(uobj);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	public User validateUser(int userId, String passsword) {

		try {
			Session session = sessionFactory.getCurrentSession();
			User uobj = session.get(User.class, userId);
			if (uobj != null) {
				if (uobj.getPassword().equals(passsword)) {
					return uobj;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {

		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from com.spring.model.User where role='customer'");
		List<User> userList = q.list();
		return userList;
	}

	@Override
	public boolean deleteUser(User uobj) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(uobj);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateUser(User uobj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(uobj);
			return true;
		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

	@Override
	public User getUserById(int userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			User uobj = session.get(User.class, userId);
			return uobj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	

}
