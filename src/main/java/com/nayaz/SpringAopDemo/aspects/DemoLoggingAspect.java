package com.nayaz.SpringAopDemo.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private static Logger logger = Logger.getLogger(DemoLoggingAspect.class.getName());

	@Before("com.nayaz.SpringAopDemo.aspects.PointcutsExpressions.forDaoPackageGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint jointpoint) {
		logger.info("Executing @Before advice on Add Account");
		MethodSignature methodSignature = (MethodSignature) jointpoint.getSignature();
		logger.info("Method Sinature: " + methodSignature);

		Object[] args = jointpoint.getArgs();

		for (Object tempArg : args) {
			logger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				logger.info("Account Name: " + account.getName());

				logger.info("Account Level: " + account.getLevel());

			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.nayaz.SpringAopDemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint jointPoint, List<Account> result) {

		String methodSignature = jointPoint.getSignature().toShortString();

		logger.info("Executing @AfterReturning on Method :" + methodSignature);

		logger.info("The list of Accounts @AfterReturning on Method :" + result);

		convertAccountNamesToUpperCase(result);

		logger.info("The list of Accounts with Upper case Names @AfterReturning on Method :" + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account account : result) {
			String upperCaseName = account.getName().toUpperCase();

			account.setName(upperCaseName);
		}

	}

	@AfterThrowing(pointcut = "execution(* com.nayaz.SpringAopDemo.dao.AccountDao.findAccounts(..))", throwing = "ex")
	public void afterThrowingFindAccountsAdvice(JoinPoint jointPoint, Throwable ex) {

		String methodSignature = jointPoint.getSignature().toShortString();

		logger.info("Executing @@AfterThrowing on Method :" + methodSignature);

		logger.info("The Exceptuion is @@AfterThrowing on Method : " + ex);

	}

	@After("execution(* com.nayaz.SpringAopDemo.dao.AccountDao.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint jointPoint) {

		String methodSignature = jointPoint.getSignature().toShortString();

		logger.info("Executing @After on Method :" + methodSignature);
	}

	@Around("execution(* com.nayaz.SpringAopDemo.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String methodSignature = proceedingJoinPoint.getSignature().toShortString();

		logger.info("Executing @Around on Method :" + methodSignature);

		long begin = System.currentTimeMillis();

		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {

			logger.warning(e.getMessage());

			throw e;
		}

		long end = System.currentTimeMillis();

		long duration = end - begin;

		logger.info("Duration is :" + duration / 1000.0 + "Seconds");

		return result;

	}
}
