package com.vivek.springannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaClassDemoApp {

	public static void main(String[] args) {
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
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
