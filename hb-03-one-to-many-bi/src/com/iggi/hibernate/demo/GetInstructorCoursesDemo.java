package com.iggi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Course;
import com.iggi.hibernate.demo.entity.Instructor;
import com.iggi.hibernate.demo.entity.InstructorDetail;
import com.iggi.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

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
				
				// begin transaction
				session.beginTransaction();
				
				// get the instructor from db
				int theId = 1;
				Instructor tempInstructor = session.get(Instructor.class,  theId);

				System.out.println("This is our instructor: " + tempInstructor);
				System.out.println("Courses: " + tempInstructor.getCourses());
				
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





