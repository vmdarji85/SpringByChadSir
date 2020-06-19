package com.vivek.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load spring configurtion file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach  myCricket = context.getBean("mycricketcoach", CricketCoach.class);
		//call method on the bean
		System.out.println(myCricket.getDailyWorkout());
		System.out.println(myCricket.getDailyFortune());
		System.out.println("Email address : " + myCricket.getEmailAddress());
		System.out.println("Team name : " + myCricket.getTeam());
		//close the context
		context.close();
		

	}

}
