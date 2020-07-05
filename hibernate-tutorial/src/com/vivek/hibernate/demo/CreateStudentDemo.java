package com.vivek.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			
			System.out.println("Creating a new student object");
			String theDateofBirthStr = "01/05/2015";
			Date theDate = DateUtils.parseDate(theDateofBirthStr);
			Student s1 = new Student("Riyansh", "darji", "riyansh@luvtocode.com",theDate);
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
