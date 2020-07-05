package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;
import com.vivek.hibernate.demo.entity.Review;
import com.vivek.hibernate.demo.entity.Student;

public class CreateMoreCoursesToVivek {

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
			int theId=2;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("\nStudent details : " + tempStudent);
			//Add new course
			System.out.println("\nAdding more courses.....");
			Course course1 = new Course("FNP Certification course");
			//add student to the courses
			System.out.println("Add student to the courses....");
			course1.addStudent(tempStudent);
			
			//save courses
			System.out.println("\nSave courses.....");
			session.save(course1);
	
			//commit 
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
