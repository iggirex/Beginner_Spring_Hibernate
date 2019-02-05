package com.iggi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// make a new student obj
			System.out.println("Creating a new stuendt object");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			
			// begin transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		
		
		}
		finally {
			factory.close();
		}
	
	}

}





