package com.vivek.springannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CricketConfig {
	
	@Bean
	public FortuneService veryNiceFortuneService() {
		return new VeryNiceFortuneService();
	}
	
	@Bean
	public Coach cricketCoach() {
		return new CricketCoach(veryNiceFortuneService());
	}

}
