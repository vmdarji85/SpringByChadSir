package com.vivek.springannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside Tenis Coach -> Default Contructor");
	}
//	
	/*
	 * @Autowired public
	 * TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService)
	 * { this.fortuneService = fortuneService; }
	 */

	/*
	 * @Autowired
	 * 
	 * public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println("Inside setter method for setFortuneService");
	 * this.fortuneService = fortuneService; }
	 */
	@PostConstruct
	public void doMystartUp() {
		System.out.println("inside my -> doMystartUp() method");
	}
	@PreDestroy
	public void doMyCleanUp() {
		System.out.println("inside my -> doMyCleanUp() method");
	}

	@Override
	public String dailyWorkout() {
		return "Do practice for backhand volley";

	}

	@Override
	public String dailyFortune() {

		return fortuneService.getFortune();
	}

}
