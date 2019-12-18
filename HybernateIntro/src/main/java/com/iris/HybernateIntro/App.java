package com.iris.HybernateIntro;

import com.iris.UserDaoImpl.UserDaoImpl;
import com.iris.daos.UserDao;
import com.iris.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     	User uObj=new User();

    	uObj.setUserName("chandan");

    	uObj.setPassword("123");
    	
    	uObj.setGender("Male");
    	uObj.setEmail("Chandan@iris.com");
    	uObj.setCity("Noida");
    	uObj.setRole("customer"); 

    	

       UserDao userDao=new UserDaoImpl();

       userDao.saveUser(uObj);
    }
}
