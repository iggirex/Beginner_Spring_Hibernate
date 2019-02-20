package com.iggi.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpanishFortuneService implements FortuneService {
	
	@PostConstruct
	public void cleanupSpanishFortuneService() {
		System.out.println("SpanishFortuneService: calling cleanup form PostConstruct method");
	}
	
	@Value("${fortune.first}")
	private String firstFortune;
	
	@Value("${fortune.second}")
	private String secondFortune;
	
	@Value("${fortune.third}")
	private String thirdFortune;
	
	@Value("${fourth}")
	private String fourthFortune;

	Random rand = new Random();
	
	@Override
	public String getFortune() {
		
		String[] fortuneArray = {firstFortune, secondFortune, thirdFortune, fourthFortune};
		String randomFortune = fortuneArray[rand.nextInt(fortuneArray.length)];
		
		return randomFortune;
	
	}

}
