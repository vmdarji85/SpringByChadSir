package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class deleteDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			//get instructor object
			int theId=2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found instructor :" + tempInstructor);
			//delete instructor
			if(tempInstructor != null) {
				System.out.println("deleting temp instructor: "+ tempInstructor);
				session.delete(tempInstructor); // also delete detail object because cascaseType =ALL
			}
			
			//commit
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			
		}

	}

}
