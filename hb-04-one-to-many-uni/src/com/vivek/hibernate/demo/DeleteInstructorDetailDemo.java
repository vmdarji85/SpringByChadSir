package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			//get instructor detail object
			
			int theId = 5;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			Instructor tempInstructor = tempInstructorDetail.getInstructor();
			
			System.out.println("The associated instructor : " + tempInstructor);
			
			// remove the link between two tables
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			//delete instructor
			
			session.delete(tempInstructorDetail);

			//commit
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			
		}

	}

}
