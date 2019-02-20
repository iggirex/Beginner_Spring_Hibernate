package com.iggi.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] fortuneArray = {
			"Cupcake cats make great Cheesy Gordita Crunches", 
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(fortuneArray.length);
		
		String theFortune = fortuneArray[index];
		
		return theFortune;
	}

}

