package com.vivek.springannotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String data[] = {
			"Beware of Wolf in ship's clothing",
			"Dilligence is mother of good luck",
			"The journey is the reward"
	};

	private Random random  = new Random();
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}
