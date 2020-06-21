package com.vivek.springannotation;

public class CricketCoach implements Coach {
	
	FortuneService fortuneService;
	
	public CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String dailyWorkout() {
		return "Practice Bowling and Batting for an hour everyday";
	}

	@Override
	public String dailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
