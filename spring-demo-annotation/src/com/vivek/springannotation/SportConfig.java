package com.vivek.springannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.vivek.springannotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneServie();
	}
	
	//define bean for our swim coach AND inject dependency
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	

}
