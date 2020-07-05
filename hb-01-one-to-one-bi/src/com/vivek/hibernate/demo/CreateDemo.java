package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Instructor;
import com.vivek.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create object of both classes
			Instructor instructor = new Instructor("kinni","darji","kdarji@luvtocode.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "luvHelath");
			//associated objects
			instructor.setInstructorDetail(tempInstructorDetail);
			//start transaction
			session.beginTransaction();
			//save instructor
			System.out.println("Saving instructor :"+ instructor);
			session.save(instructor);
			//commit
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			
		}

	}

}
