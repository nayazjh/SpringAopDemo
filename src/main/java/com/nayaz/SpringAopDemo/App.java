package com.nayaz.SpringAopDemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nayaz.SpringAopDemo.dao.AccountDao;
import com.nayaz.SpringAopDemo.dao.MembershipDao;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        
        Account account = new Account();
        
        account.setName("Nayaz");
        
        account.setLevel("SSE");
        
        accountDao.addAccount(account, true);
        
        accountDao.doWork();
        
        accountDao.setName("nayaz");
        
        List<Account> listAccounts = accountDao.findAccounts(false);
        
        System.out.println("After Returning on Method");
        
        System.out.println("List of Accounts :" +listAccounts);
        
        System.out.println("After throwing Exception on Method");

        
        List<Account> listAccounts1 = null;
        
        try {
        	boolean status = false;
        	
        	listAccounts1 = accountDao.findAccounts(status);
        } catch (Exception e) {
        	
        	System.out.println("Caught Exception In AfterThrowing :" +e);
		}


    	System.out.println("Exception In AfterThrowing :");

        String name = accountDao.getName();

        
        accountDao.setServiceCode("NR");
        
        String serviceCode = accountDao.getServiceCode();


        
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        
        membershipDao.addMemberAccount(account);
        
        membershipDao.goToGym();

        
        context.close();
    }
}
