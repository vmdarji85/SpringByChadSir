package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class CreateCourse {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// cretae session
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();
			//get instructor from db
			int tempId = 1;
			Instructor tempInstructor = session.get(Instructor.class, 1);
			//create course
			Course course1 = new Course("Master in Java 2020");
			Course course2 = new Course("Master in Phython 2020");
			// add course to instructor
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			//save courses
			session.save(course1);
			session.save(course2);
			//commit 
			
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
