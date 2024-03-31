package com.aaslin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		/*
		 * //Task 1 - connect to db using hibernate .
		 * System.out.println("Connection established successfully"); //Task 2 - retrive
		 * employee data only firstname and lastname. TypedQuery<Employee> query =
		 * session.
		 * createQuery("select new com.aaslin.Employee(e.firstName, e.lastName) from Employee e"
		 * ,Employee.class); List<Employee> list = query.getResultList(); for (Employee
		 * employee : list) { String firstName = employee.getFirstName(); String
		 * lastName = employee.getLastName(); System.out.println(firstName + "\t \t" +
		 * lastName); System.out.println("\n"); }
		 */

		// Task - 6 update the record of id=5 and update the salary,firstname,lastname
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, 5);
		if (employee != null) {
			employee.setFirstName("newly ");
			employee.setLastName("updatedName");
			session.update(employee);
			transaction.commit();
			System.out.println("Record updated successfully.");
		} else {
			System.out.println("Employee with ID=5 not found.");
		}
		session.close();
	}

}