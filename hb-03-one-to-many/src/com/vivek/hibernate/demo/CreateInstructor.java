package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//cretae session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create object of both classes
			Instructor instructor = new Instructor("Chad", "dabry", "chad@luvtocode.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "LuvtoCode");
			//associated objects
			instructor.setInstructorDetail(instructorDetail);
			
			//begin transaction
			session.beginTransaction();
			
			//save instructor
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}

