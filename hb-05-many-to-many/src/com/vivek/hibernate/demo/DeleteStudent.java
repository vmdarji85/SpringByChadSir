package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;
import com.vivek.hibernate.demo.entity.Review;
import com.vivek.hibernate.demo.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// cretae session
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();
			
			//get student from db
			int courseId=12;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println(" temp Course: " + tempCourse);
			
			session.delete(tempCourse);
			
			System.out.println("course is deleted.....");
			
			//commit 
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
