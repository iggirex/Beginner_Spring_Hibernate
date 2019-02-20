package com.iggi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config Java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);
		
		// get the bean from the Spring container
		SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call methods
		System.out.println(myCoach.getDailyWorkout());
		
		// call daily fortune method
		System.out.println(myCoach.getDailyFortune());
		
		// call our new methods that have props values injected
		System.out.println("email: " + myCoach.getEmail());
		System.out.println("email: " + myCoach.getTeam());
		
		// close the container
		context.close();
	}

}
