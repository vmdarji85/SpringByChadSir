package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			//get instructor detail object
			
			int theId=1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv to code:Intructor " + tempInstructor);	
			
			//get courses
			
			System.out.println("Course : " + tempInstructor.getCourses());
			
			
	
			
			//commit
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			
		}

	}

}
