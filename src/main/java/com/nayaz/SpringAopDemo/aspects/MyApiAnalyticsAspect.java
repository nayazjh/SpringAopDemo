package com.nayaz.SpringAopDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.nayaz.SpringAopDemo.aspects.PointcutsExpressions.forDaoPackageGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("Performing API Analytics");
	}

}
