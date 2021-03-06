package com.iggi.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Instructor;
import com.iggi.hibernate.demo.entity.InstructorDetail;
import com.iggi.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			// get instructorDetail
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(
									InstructorDetail.class, theId);
			
			
			// create print the associated Instructor
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// create print the associated Instructor
			System.out.println("The associated instructor: " 
							+ tempInstructorDetail.getInstructor());
			
			// remove the associated object reference
			// break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// deleting tempInstructorDetail
			System.out.println("Deleting tempInstructorDetail: " +
								"tempInstructorDetail");
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	
	}

}





