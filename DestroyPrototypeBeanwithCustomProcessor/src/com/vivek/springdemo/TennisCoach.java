package com.vivek.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
	
	@Autowired
	FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">>TennisCoach => inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartUp() {
		System.out.println("TennisCoach => Inside my startup method");
	}
	@PreDestroy
	public void doMyCleanup() {
		System.out.println("TennisCoach => Inside my cleanup method ");
	}

	@Override
	public String getDailyWorkout() {

		return "Do practice for backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(">> Tenniscoach => Inside the Destroy method");
		
	}

}
