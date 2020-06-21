package com.vivek.springannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoAppwithProperties {

	public static void main(String[] args) {
		//Read Spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//Retrieve bean from spring container
		SwimCoach swimBean = context.getBean("swimCoach", SwimCoach.class);
		//call method 
		System.out.println(swimBean.dailyWorkout());
		
		System.out.println(swimBean.dailyFortune());
		
		System.out.println("Email : " + swimBean.getEmail());
		
		System.out.println("Team :" + swimBean.getTeam());
		//close context
		
		context.close();
		

	}

}
