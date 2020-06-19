package com.vivek.springDemo;

public class BaseBallCoach implements Coach {
	
	//define private field for dependency
	private FortuneService fortuneService;
		
	
	//define a constructor for dependency injection
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Spend 30 min on Batting practice";
	}

	@Override
	public String getDailyFortune() {
		// call my fortune service to get a fortune
		return fortuneService.getFortune();
	}

}
