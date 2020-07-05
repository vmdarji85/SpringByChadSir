package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;
import com.vivek.hibernate.demo.entity.Review;
import com.vivek.hibernate.demo.entity.Student;

public class DeleteCourse {

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
			int studId=2;
			Student student = session.get(Student.class, studId);
			
			System.out.println("Student details " + student);
			
			session.delete(student);
			
			System.out.println("Student is deleted.....");
			
			//commit 
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
