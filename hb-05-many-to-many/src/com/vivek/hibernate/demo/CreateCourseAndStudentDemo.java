package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;
import com.vivek.hibernate.demo.entity.Review;
import com.vivek.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// create course
			System.out.println("\nCreating new Course.....");
			Course course = new Course("Spring Framework 5.0");
			//saving course
			System.out.println("Saving course......");
			session.save(course);
			
			// create student
			System.out.println("\nCreating a new students....");
			Student tempStudent1 = new Student("Vivek","darji", "vdarji@luv2code.com");
			Student tempStudent2 = new Student("kinni","darji", "kdarji@luv2code.com");
			Student tempStudent3 = new Student("umang","darji", "udarji@luv2code.com");
			
			// add student to course
			System.out.println("\nAdding Students to the course....");
			course.addStudent(tempStudent1);
			course.addStudent(tempStudent2);
			course.addStudent(tempStudent3);
			
			//save students
			System.out.println("\nSaving students.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			//commit 
			session.getTransaction().commit();
			System.out.println("Done !!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
