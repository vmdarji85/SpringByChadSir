package com.vivek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vivek.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// Get Session
		Session session = factory.getCurrentSession();

		// begin transactions
		session.beginTransaction();

		// delete students
		
		// 1. first way
//
//		int count = session.createQuery("delete Student where id=5").executeUpdate();
//
//		if (count > 0) {
//			System.out.println("Student with id 5 is deleted successfully");
//		} else {
//			System.out.println("There is error while deleting a student");
//		}
		
		//2. second way
		
		int stId = 3;
		
		Student myStudent = session.get(Student.class, stId);
		
		System.out.println("Before Delete" +myStudent);
		
		session.delete(myStudent);
		System.out.println("After Delete" +myStudent);
		System.out.println("Delete successfully");

		// commit
		session.getTransaction().commit();
	}

}
