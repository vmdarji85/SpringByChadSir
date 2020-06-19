package com.vivek.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//get bean from spring container
		 Coach coach = context.getBean("mycoach", Coach.class);
		 Coach alphaCoach = context.getBean("mycoach", Coach.class);
		//check if they are same
		 boolean result = (coach == alphaCoach);
		//check result
		 System.out.println("\nPointing to same Object :" + result);
		 System.out.println("\nMemory location for coach : " + coach);
		 System.out.println("\nMemory location for alphaCoach : " + alphaCoach);
		

	}

}
