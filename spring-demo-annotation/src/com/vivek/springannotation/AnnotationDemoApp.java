package com.vivek.springannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call method on bean
		System.out.println(theCoach.dailyWorkout());
		
		//call Daily fortune method
		
		System.out.println(theCoach.dailyFortune());
		
		//close context
		context.close();

	}

}
