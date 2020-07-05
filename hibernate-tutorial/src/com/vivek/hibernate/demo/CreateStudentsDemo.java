package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class CreateStudentsDemo {

	public static void main(String[] args) {
		//create Session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// create three students objects
			Student s2 = new Student("kinnari", "darji", "kdari@luvtocode.com");
			Student s3 = new Student("riyansh","darji", "hriyansh@luvtocode.com");
			Student s4 = new Student("rishan", "darji","rishan@luvtocode.com");
			// create a transaction
			session.beginTransaction();
			//save three students
			session.save(s2);
			session.save(s3);
			session.save(s4);
			//commit
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

}
