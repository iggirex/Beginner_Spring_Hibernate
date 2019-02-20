package com.iggi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TangoCoach implements Coach {

	@Autowired
	@Qualifier("spanishFortuneService")
	private FortuneService myFortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Lez dance bitch!";
	}

	@Override
	public String getDailyFortune() {
		
		return myFortuneService.getFortune();
	}

}
