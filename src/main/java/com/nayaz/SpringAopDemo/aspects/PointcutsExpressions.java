package com.nayaz.SpringAopDemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsExpressions {
	
	@Pointcut("execution(* com.nayaz.SpringAopDemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.nayaz.SpringAopDemo.dao.*.get*(..))")
	public void getterPointCut() {
		
	}
	
	@Pointcut("execution(* com.nayaz.SpringAopDemo.dao.*.set*(..))")
	public void setterPointCut() {
		
	}
	
	@Pointcut("forDaoPackage() && !(getterPointCut() || setterPointCut())")
	public void forDaoPackageGetterSetter() {
		
	}
	

}
