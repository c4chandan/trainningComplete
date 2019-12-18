package com.eshop.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.dao.ProductDao;
import com.eshop.model.Product;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}
	
	public Product validateUser(int Id, String name) {

		try {
			Session session = sessionFactory.getCurrentSession();
			Product uobj = session.get(Product.class, Id);
			if (uobj != null) {
				if (uobj.getProductName().equals(name)) {
					return uobj;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	@Override
	public Product getProductById(int uid) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Product pro=session.get(Product.class,uid);

			return pro;

			}

			catch(Exception e){

				e.printStackTrace();

			}

			return null;
	}

	@Override
	public List<Product> getAllProduct() {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query query=session.createQuery("from com.eshop.model.User");

			return query.list();

			}

			catch(Exception e){

				e.printStackTrace();

			}
		return null;
	}

	

}
