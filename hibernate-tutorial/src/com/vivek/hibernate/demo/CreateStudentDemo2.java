package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class CreateStudentDemo2 {

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
			Student s1 = new Student("Vivek", "darji", "vivek@luvtocode.com");
			//start  a transaction
			session.beginTransaction();
			//save the student object
			session.save(s1);
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}

	}

}
