package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vivek.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class).buildSessionFactory();						
		//Create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
		} finally {
			int studentId=5;
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting studnet with id: " + studentId);
			
			//retrieve student 
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student");
			myStudent.setFirstName("Mogli");
			
			//commit transaction
			
			session.getTransaction().commit();
			
			//New update - update email for all student
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//update email for all students
			
			System.out.println("Updating email for all students");
			
			int count = session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			if( count > 0) {
				System.out.println("Update successful !!");
			} else {
				System.out.println("Error in update");
			}
			
			//commit 
			
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!!");
			
			
		}
	}
			
			

}
