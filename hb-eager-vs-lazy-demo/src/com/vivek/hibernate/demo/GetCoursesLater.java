package com.vivek.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class GetCoursesLater {

	public static void main(String[] args) {
		// create Session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			  // start a transaction
			session.beginTransaction();
	           // get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instrctor : " + tempInstructor);
			 // commit transaction
			session.getTransaction().commit();
			//close the transaction
			session.close();
			System.out.println("\nSession Closed!!\n");
			//start new session 
			System.out.println("\nOpening a new Session!!\n");
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();
			 // get courses for a given instructor using query
			Query<Course> query = session.createQuery("Select c from Course c "
					+ "where c.instructor.id=:theInstructor",Course.class);
			//set parameter
			query.setParameter("theInstructor", theId);
			List<Course> courses= query.getResultList();
			 // now assign to instructor object in memory
			tempInstructor.setCourses(courses);
			//printing all courses
			System.out.println("Luv to code: courses :" + tempInstructor.getCourses());
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
