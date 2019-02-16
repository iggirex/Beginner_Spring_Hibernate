package com.iggi.hibernate.demo.entity;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Practice_Hibernate {

	public static void main(String[] args) {
		
		final int employeeId = 6;
		final String employeeCompany = "Kitty Comp";
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee firstEmployee = new Employee("asdf", "asdf", "asdf Comp");
			
			System.out.println("Beginning first transaction");
			session.beginTransaction();
			
			System.out.println("Saving this employee: " + firstEmployee);
			session.save(firstEmployee);
			
			System.out.println("Commiting first transaction");
			session.getTransaction().commit();
			
			System.out.println("Getting new Session from factory");
			session = factory.getCurrentSession();
			
			System.out.println("Beginning second transaction");
			session.beginTransaction();
			
			System.out.println("Getting student with Id: " + employeeId);
			Employee gotStudent = session.get(Employee.class, employeeId);
			
			System.out.println("Retrived employee: " + gotStudent);
			
			System.out.println("Getting all employees from company: " + employeeCompany);
			List<Employee> employeeList = session.createQuery("FROM Employee e WHERE e.company "
															+ "LIKE 'Kitty Comp'").getResultList();
			
			System.out.println("This is the list of employees working at " + employeeCompany + 
								": " + employeeList);
			
			System.out.println("Deleting employee with employeeId: " + employeeId);
			
			Employee deletingEmployee = session.get(Employee.class, employeeId);
			session.createQuery("DELETE FROM Employee WHERE id=" + employeeId).executeUpdate();
			session.getTransaction().commit();
			
			
		} catch (Exception exc) {
			System.out.println(exc);
		} finally {
			factory.close();
		}
		
	}

}
