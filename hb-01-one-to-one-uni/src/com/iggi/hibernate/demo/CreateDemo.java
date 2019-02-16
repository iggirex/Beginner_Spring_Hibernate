package com.iggi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Instructor;
import com.iggi.hibernate.demo.entity.InstructorDetail;
import com.iggi.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
	
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			// create the objects
			
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetails = 
					new InstructorDetail(
							"luv2codeUTUBEZ",
							"Luv 2 code!!!");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetails);
			
			

			Instructor tempInstructor2 = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetails2 = 
					new InstructorDetail(
							"MadhUTUBEZ",
							"Madhu Luvz 2 code!!!");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetails2);
			
			
			
			// begin transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of Cascade.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		
		
		}
		finally {
			factory.close();
		}
	
	}

}





