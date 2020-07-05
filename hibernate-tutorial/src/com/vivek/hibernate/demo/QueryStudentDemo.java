package com.vivek.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();						
		//Create Session
		
		Session session = factory.getCurrentSession();
		
		
		
		try {
			//begin transaction
			session.beginTransaction();
			//create hibernate query
		List<Student> students = 	session.createQuery("from Student").getResultList();
		
		// retrive student using for loop
		
		display(students);
		
		// get student using last name
		
		System.out.println("Using Lastname query");
		
		students = session.createQuery("from Student s where s.firstName='Vivek'").getResultList();
		
		display(students);
		
		// get student  where email LIKE '%luvtocode.com
		System.out.println("Using LIKE query");
		students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
		display(students);
	
			
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
			
		} finally {
			session.close();
		}

	}

	private static void display(List<Student> students) {
		for(Student student:students) {
			System.out.println(student);
		}
	}

}
