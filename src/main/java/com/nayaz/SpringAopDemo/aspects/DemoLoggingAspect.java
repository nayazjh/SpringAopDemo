package com.nayaz.SpringAopDemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nayaz.SpringAopDemo.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

	@Before("com.nayaz.SpringAopDemo.aspects.PointcutsExpressions.forDaoPackageGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint jointpoint) {
		System.out.println("Executing @Before advice on Add Account");
		MethodSignature methodSignature = (MethodSignature) jointpoint.getSignature();
		System.out.println("Method Sinature: " +methodSignature);
		
		Object[] args = jointpoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("Account Name: "+ account.getName());
				
				System.out.println("Account Level: "+ account.getLevel());

			}
		}
	}
	
	@AfterReturning(pointcut="execution(* com.nayaz.SpringAopDemo.dao.AccountDao.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint jointPoint, List<Account> result) {
		
		String methodSignature = jointPoint.getSignature().toShortString();
		
		System.out.println("Executing @AfterReturning on Method :" +methodSignature);
		
		System.out.println("The list of Accounts @AfterReturning on Method :" + result);
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("The list of Accounts with Upper case Names @AfterReturning on Method :" + result);

 
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account account : result) {
			String upperCaseName = account.getName().toUpperCase();
			
			account.setName(upperCaseName);
		}
		
	}

}
