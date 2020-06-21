package com.vivek.springannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadingFromFileApp {

	public static void main(String[] args) {
		
		// Read the spring Configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from Spring Container
		
		SwimCoach  swimCoach = context.getBean("swimCoach", SwimCoach.class);
		//call Method
		System.out.println(swimCoach.dailyWorkout());
		
		System.out.println(swimCoach.dailyFortune());
		
		
		
		
		//Close context
		
		context.close();

	}

}
