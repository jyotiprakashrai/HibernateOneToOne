package com.jyoti.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.Address;
import com.jyoti.hibernate.model.Employee;
import com.jyoti.hibernate.util.HibernateUtil;

/* Hibernate One to One Mapping using XML configuration 
 *
 */

public class HibernateOneToOneTest {
	
public static void main(String[] args) {
		
		Employee employee = buildDemoTransaction();
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(employee);
		//Commit transaction
		tx.commit();
		System.out.println("Transaction ID="+employee.getId());
		
		//Get Saved Trasaction Data
		printTransactionData(employee.getId(), sessionFactory);
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

	private static void printTransactionData(long id, SessionFactory sessionFactory) {
		Session session = null;
		Transaction tx = null;
		try{
			//Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			//start transaction
			tx = session.beginTransaction();
			//Save the Model object
			Employee employee = (Employee) session.get(Employee.class, id);
			//Commit transaction
			tx.commit();
			System.out.println("Transaction Details=\n"+employee);
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}
	}

	private static Employee buildDemoTransaction() {
		Employee employee = new Employee();
		employee.setName("Manish");
		employee.setEmail("manish@com");
	
		
		Address address = new Address();
		address.setCity("Gaziabad");
		address.setState("UP");
		
		employee.setAddress(address);
		
		address.setEmployee(employee);
		return employee;
	}


}
