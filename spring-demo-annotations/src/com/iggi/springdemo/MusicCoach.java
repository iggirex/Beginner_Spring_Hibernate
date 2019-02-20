package com.iggi.springdemo;

public class MusicCoach implements Coach {

	private SosoFortuneService sosoFortuneService;
	
	public MusicCoach(SosoFortuneService injectedSosoFortuneService) {
		sosoFortuneService = injectedSosoFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return sosoFortuneService.getFortune();
	}

}
