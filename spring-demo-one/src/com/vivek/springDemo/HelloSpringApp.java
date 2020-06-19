package com.vivek.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	
	public static void main(String[] args) {
		
		//load spring configuration file
		
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container;
		
		Coach coach = (Coach) context.getBean("mycoach",Coach.class);
							
		
		//call methods on bean
		
		System.out.println(coach.getDailyWorkout());
		
		//call new method from coach class
		
		System.out.println(coach.getDailyFortune());
		//close context
		
		context.close();
		

	}

}
