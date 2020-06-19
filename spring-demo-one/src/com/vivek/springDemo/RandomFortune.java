package com.vivek.springDemo;

import java.util.Random;

public class RandomFortune implements FortuneService {
	
	private String data[] = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		
		int index = random.nextInt(data.length);
		String myFortune = data[index];
		
		return myFortune;
	}

}
