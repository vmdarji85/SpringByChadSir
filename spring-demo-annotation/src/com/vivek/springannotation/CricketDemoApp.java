package com.vivek.springannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CricketDemoApp {

	public static void main(String[] args) {
		//Read Spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CricketConfig.class);
		//Retrieve bean from spring container
		Coach cricketBean = context.getBean("cricketCoach", Coach.class);
		//call method 
		System.out.println(cricketBean.dailyWorkout());
		
		System.out.println(cricketBean.dailyFortune());
//		
//		System.out.println("Email : " + cricketBean.getEmail());
//		
//		System.out.println("Team :" + cricketBean.getTeam());
		//close context
		
		context.close();
		

	}

}
