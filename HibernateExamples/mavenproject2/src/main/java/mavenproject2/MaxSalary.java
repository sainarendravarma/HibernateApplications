package mavenproject2;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MaxSalary {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Connection established successfully");
		//Task 3 application that uses a HQL (Hibernate Query Language) query to get the maximum salary of employees in the IT department
		TypedQuery<Double> query = session.createQuery("select max(e.salary) from Employee e where e.department = 'dev' ",Double.class);
		Double maxSalary = query.getSingleResult();
		System.out.println("Maximum salary in the dev department: " + maxSalary);

		
		session.close();
	}

}