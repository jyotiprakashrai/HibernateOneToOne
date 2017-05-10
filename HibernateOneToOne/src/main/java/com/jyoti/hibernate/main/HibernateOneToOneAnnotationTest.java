package com.jyoti.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.AddressAnno;
import com.jyoti.hibernate.model.EmployeeAnno;
import com.jyoti.hibernate.util.HibernateAnnotationUtil;

/* Hibernate OneToOne Mapping using using JPA annotations configuration.
 *
*/

public class HibernateOneToOneAnnotationTest {
	
public static void main(String[] args) {
		
		EmployeeAnno employeeAnno = buildDemoTransaction();
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created using annotations configuration");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(employeeAnno);
		//Commit transaction
		tx.commit();
		System.out.println("Annotation Example. Transaction ID="+employeeAnno.getId());
		
		//Get Saved Trasaction Data
		printTransactionData(employeeAnno.getId(), sessionFactory);
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()){
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
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			//start transaction
			tx = session.beginTransaction();
			//Save the Model object
			EmployeeAnno employeeAnno = (EmployeeAnno) session.get(EmployeeAnno.class, id);
			//Commit transaction
			tx.commit();
			System.out.println("Annotation Example. Transaction Details=\n"+employeeAnno);
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}
	}

	private static EmployeeAnno buildDemoTransaction() {
		EmployeeAnno employeeAnno = new EmployeeAnno();
		employeeAnno.setName("Jyoti Prakash");
		employeeAnno.setEmail("jyoti@com");
		
		
		AddressAnno addressAnno = new AddressAnno();
		addressAnno.setCity("New Delhi");
		addressAnno.setState("Delhi");
		
		
		employeeAnno.setAddressAnno(addressAnno);
		
		addressAnno.setEmployeeAnno(employeeAnno);
		
		return employeeAnno;
	}

}
