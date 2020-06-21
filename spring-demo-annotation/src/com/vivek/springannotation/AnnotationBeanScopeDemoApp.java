package com.vivek.springannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		//check both are same 
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Both beans are equals : " + result);
		System.out.println("\nMemory location for coach" + theCoach);
		System.out.println("\nMemory location for alpha coach : " + alphaCoach);
		
		// close context
		
		context.close();
		

	}

}
