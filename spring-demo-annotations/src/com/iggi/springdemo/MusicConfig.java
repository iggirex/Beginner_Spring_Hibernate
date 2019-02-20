package com.iggi.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {

	@Bean
	public SosoFortuneService sosoFortuneService() {
		return new SosoFortuneService();
	}
	
	@Bean
	public MusicCoach musicCoach() {
		return new MusicCoach(sosoFortuneService());
	}
}
