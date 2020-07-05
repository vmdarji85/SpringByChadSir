package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;
import com.vivek.hibernate.demo.entity.Review;
import com.vivek.hibernate.demo.entity.Student;

public class getCoursesToVivek {

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
			int theId=1;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nStudent details : " + tempStudent);
			System.out.println("\nStudent's course details :" + tempStudent.getCourses());
		
			
			//commit 
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
