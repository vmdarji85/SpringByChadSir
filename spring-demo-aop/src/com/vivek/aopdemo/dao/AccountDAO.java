package com.vivek.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.vivek.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account acccount, boolean vipFlag) {
		System.out.println(getClass() +": DOING MY DB WORK : ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : do work()");
		
		return true;
	}

}
