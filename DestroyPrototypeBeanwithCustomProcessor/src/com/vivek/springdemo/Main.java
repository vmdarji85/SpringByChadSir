package com.vivek.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve beans from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// check both are same
		boolean result = (theCoach == alphaCoach);

		System.out.println("\nBoth beans are equals : " + result);
		System.out.println("\nMemory location for coach" + theCoach);
		System.out.println("\nMemory location for alpha coach : " + alphaCoach + "\n");

		// close context

		context.close();

	}

}
