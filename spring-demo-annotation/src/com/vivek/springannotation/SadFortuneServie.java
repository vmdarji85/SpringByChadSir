package com.vivek.springannotation;

public class SadFortuneServie implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad day :(";
	}

}
