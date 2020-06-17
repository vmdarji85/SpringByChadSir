package com.vivek.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	
	public static void main(String[] args) {
		
		//load spring configuration file
		
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container;
		
		Coach coach = (Coach) context.getBean("mytcoach",Coach.class);
							
		
		//call methods on bean
		
		System.out.println(coach.getDailyWorkout());
		//close context
		
		context.close();
		

	}

}
