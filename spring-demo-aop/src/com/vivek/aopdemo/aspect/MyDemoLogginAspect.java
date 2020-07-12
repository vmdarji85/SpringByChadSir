package com.vivek.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyDemoLogginAspect {
	//This is where we add all our related advaices for login
	@Pointcut("execution(* com.vivek.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
		
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(com.vivek.aopdemo.Account))")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice annotation on addAccount()");
		
		
	}
}
