package com.iggi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MusicCoachDemoApp {

	public static void main(String[] args) {

		// import config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MusicConfig.class);
		
		// get bean
		Coach myCoach = context.getBean("musicCoach", Coach.class);
		
		// call music coach method for fortune
		System.out.println(myCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}
