package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.vivek.hibernate.demo.entity.Course;
import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			//option 2: hibernate query with HQL
			//get instructor detail object
			
			int theId=1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstuctorId", Instructor.class);
			
			query.setParameter("theInstuctorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv to code:Intructor " + tempInstructor);	
			
			//commit
			session.getTransaction().commit();
			
			//close session
			
			session.close();
			
			System.out.println("\nThe Session is now Closed!\n");
		
			
			//get courses
			System.out.println("luv to code : Course : " + tempInstructor.getCourses());
			System.out.println("Done!!!");
			
			
		} finally {
			session.close();
			factory.close();
			
		}

	}

}
