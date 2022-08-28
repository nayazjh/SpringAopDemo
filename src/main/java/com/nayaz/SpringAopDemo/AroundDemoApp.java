package com.nayaz.SpringAopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nayaz.SpringAopDemo.service.TrafficFortuneService;

public class AroundDemoApp 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(DemoConfig.class);
        
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        
        
        System.out.println("Calling getFortune() Method");
        
        String data = trafficFortuneService.getFortune();
        
        System.out.println("My Fortune is :" + data);
        
        System.out.println("Finished");
        context.close();
    }
}
