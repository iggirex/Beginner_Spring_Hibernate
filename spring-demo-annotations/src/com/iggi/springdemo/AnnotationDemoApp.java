package com.iggi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the Spring container
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		Coach myTangoCoach = context.getBean("tangoCoach", Coach.class);
		
		// call methods
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myTangoCoach.getDailyWorkout());
		
		// call daily fortune method
		System.out.println(myTangoCoach.getDailyFortune());
		// close the container
		context.close();
	}

}
