package com.nayaz.SpringAopDemo.dao;

import org.springframework.stereotype.Component;

import com.nayaz.SpringAopDemo.Account;

@Component
public class MembershipDao {
	
	public String addMemberAccount(Account account) {
		System.out.println(getClass() + " DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		
		return "nayaz";
	}
	
	public void goToGym() {
		System.out.println(getClass() + " I AM GOING TO GYM FOR WORKOUT");
	}

}
