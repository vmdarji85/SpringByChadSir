package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating a new student");
			Student tempStudent = new Student("daffy", "duck", "daffy@luvtocode.com");
			//start  a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			//reading student 
			System.out.println("Saved Student. Student id is: "+ tempStudent.getId());
			
			//creating a new session and begin transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			//retrieve student based on the id: primary key
			 System.out.println("\nGettign student with Id: " + tempStudent.getId());
			Student student = session.get(Student.class, tempStudent.getId());
			System.out.println(student);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} finally {
			session.close();
		}

	}

}
