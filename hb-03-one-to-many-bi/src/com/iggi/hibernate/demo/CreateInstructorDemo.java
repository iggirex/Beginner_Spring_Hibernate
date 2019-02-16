package com.iggi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Course;
import com.iggi.hibernate.demo.entity.Instructor;
import com.iggi.hibernate.demo.entity.InstructorDetail;
import com.iggi.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

		public static void main(String[] args) {
		
			// create session factory
			SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
			
			// create session
			Session session = factory.getCurrentSession();
			
			try {
				
				Instructor tempInstructor = 
						new Instructor("Susan", "Public", "susan@luv2code.com");
				
				InstructorDetail tempInstructorDetails = 
						new InstructorDetail(
								"utube",
								"Video Games");
				
				// associate the objects
				tempInstructor.setInstructorDetail(tempInstructorDetails);
				
				
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
				// add clean up code
				session.close();
				
				factory.close();
			}
		
		}

	}





