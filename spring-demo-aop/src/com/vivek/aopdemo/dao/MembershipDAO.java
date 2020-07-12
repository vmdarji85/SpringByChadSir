package com.vivek.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addMembershipAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK : ADDING MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I am goign to sleep now");
	}
}
