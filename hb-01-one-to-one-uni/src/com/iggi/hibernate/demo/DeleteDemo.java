package com.iggi.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Instructor;
import com.iggi.hibernate.demo.entity.InstructorDetail;
import com.iggi.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			// begin transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			System.out.println("Found instructo: " + tempInstructor);
			
			// delete the instructors
			
			// Note: will ALSO delete associated "details" object
			// because  of CascadeType.ALL;
			//
			System.out.println("Deleting: " + tempInstructor);
			session.delete(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		
		
		}
		finally {
			factory.close();
		}
	
	}

}





