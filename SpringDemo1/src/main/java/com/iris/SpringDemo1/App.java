package com.iris.SpringDemo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iris.model.Car;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("I m main");
    	ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        
    	Car car=(Car)context.getBean("obj2");
    	System.out.println(car);
        
     
        
    }
}
