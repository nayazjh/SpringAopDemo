package com.nayaz.SpringAopDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nayaz.SpringAopDemo.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean status) {
		
		if(status) {
			throw new RuntimeException("No Data found in the list");
		}

		List<Account> myAccounts = new ArrayList<>();

		myAccounts.add(new Account("Rashida", "SE"));
		myAccounts.add(new Account("Heena", "CE"));
		myAccounts.add(new Account("Shirin", "MBA"));

		return myAccounts;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {

		System.out.println(getClass() + ": in setServiceCode()");

		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public boolean doWork() {
		System.out.println(getClass() + " DOING SOME WORK doWork()");
		return true;
	}

}
