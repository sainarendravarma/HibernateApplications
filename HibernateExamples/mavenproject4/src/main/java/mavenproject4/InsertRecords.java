package mavenproject4;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//insert 10 records in database using hibernate
public class InsertRecords {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 19; i <= 29; i++) {
			Employee employee = new Employee();
			employee.setId(i);
			employee.setName("LastName" + i);
			employee.setDepartment("IT" + i);
			employee.setSalary(500 + i * 100); // Incrementing salary for each record

			session.save(employee);
		}

		// Task 6 - 3)delete a record based on condition
		/*
		 * String hql = "delete from Organisation e where e.id = :id"; Query query =
		 * session.createQuery(hql); query.setParameter("id", 7);
		 * 
		 * // Execute the query int rowCount = query.executeUpdate();
		 * System.out.println("Rows affected: " + rowCount);
		 */
		transaction.commit();
		System.out.println("Records inserted successfully.");
	}

}
