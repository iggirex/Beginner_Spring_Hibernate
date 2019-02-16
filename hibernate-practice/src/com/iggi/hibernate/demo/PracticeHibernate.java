package com.iggi.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iggi.hibernate.demo.entity.Employee;

public class PracticeHibernate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee firstEmployee = new Employee("Patrick", "Bateman", "Corp Inc");
			
			session.beginTransaction();
			
			session.save(firstEmployee);
			
			session.getTransaction().commit();
			
			
		} catch (Exception exc) {
			System.out.println(exc);
		} finally {
			factory.close();
		}
		
	}

}
