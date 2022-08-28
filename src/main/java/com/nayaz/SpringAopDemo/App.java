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
        
        List<Account> listAccounts = accountDao.findAccounts();
        
        System.out.println("After Returning on Method");
        
        System.out.println("List of Accounts :" +listAccounts);

        
        String name = accountDao.getName();

        
        accountDao.setServiceCode("NR");
        
        String serviceCode = accountDao.getServiceCode();


        
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        
        membershipDao.addMemberAccount(account);
        
        membershipDao.goToGym();

        
        context.close();
    }
}
