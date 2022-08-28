package com.nayaz.SpringAopDemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return "Heavy Traffic This morning";
	}

	public String getFortune(boolean value) {
		
		if(value) { 
			throw new RuntimeException("Major Accident! Highway closed!");
		}
		return getFortune();
	}

}
