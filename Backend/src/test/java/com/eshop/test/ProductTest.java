package com.eshop.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.config.DbConfig;
import com.eshop.dao.ProductDao;
import com.eshop.dao.UserDao;
import com.eshop.model.Product;
import com.eshop.model.User;



public class ProductTest {


	private static ProductDao productDaoObj;
	private static UserDao userDaoObj;
	

	@BeforeClass
	public static void init(){
		System.out.println("I m in init - start");

		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

		productDaoObj=context.getBean(ProductDao.class,"ProductDao");
		userDaoObj=context.getBean(UserDao.class,"UserDao");

   	 	System.out.println("I m in init - end");

	}
	
	@Test
	@Ignore
	public void hello()
	{
		User user=new User();
		user.setGender("Female");
		user.setName("Ranu Mandal");
		user.setPassword("ranu");
		user.setRole("Customer");
		user.setUserId(1001);
		
		assertTrue("Not able to add User",userDaoObj.registerUser(user));
	}
	
	@Test
	@Ignore
	public void addProductTest(){

		Product p=new Product();

		p.setProductName("Trouser");

		p.setPrice(1500);;

		boolean r=productDaoObj.addProduct(p);

		assertTrue("Problem in Adding Product", r);
	}
	

	@Test

	@Ignore

	public void getProductByIdTest(){

		Product pObj=productDaoObj.getProductById(2741);

		assertNotNull("Product with given id doesnt exist", pObj);

	}

}
