package com.vivek.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//get bean from spring container
		 Coach coach = context.getBean("mycoach", Coach.class);
		 
		 System.out.println(coach.getDailyFortune());
		 
		 context.close();

	}

}
