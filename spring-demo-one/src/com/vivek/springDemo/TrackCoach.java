package com.vivek.springDemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		System.out.println("TrackCoach -> argument constructor");
		this.fortuneService = fortuneService;
		
	}
	public TrackCoach( ) {
		System.out.println("TrackCoach -> no-arg - constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run 5k to complete workout";
	}

	@Override
	public String getDailyFortune() {
		return  "Just do it: "+ fortuneService.getFortune();
	}
	
	public void doMyStarupStuff() {
		System.out.println("Track Coach => inside doMyStarupStuff method");
		
	}
	
	public void doMyCleanupStuff() {
		System.out.println("Track Coach => inside doMyCleanupStuff method");
		
	}

}
