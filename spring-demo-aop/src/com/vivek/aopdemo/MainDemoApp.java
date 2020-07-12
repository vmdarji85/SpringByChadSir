package com.vivek.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vivek.aopdemo.dao.AccountDAO;
import com.vivek.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//read bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class );
		//read membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		System.out.println("\nCalling membership account method");
		
		//calling second time
		theMembershipDAO.addMembershipAccount();;
		theMembershipDAO.goToSleep();
		//close context
		context.close();

	}

}
