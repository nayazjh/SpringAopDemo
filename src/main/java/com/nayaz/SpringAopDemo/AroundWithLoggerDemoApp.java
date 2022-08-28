package com.nayaz.SpringAopDemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nayaz.SpringAopDemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp 
{
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(DemoConfig.class);
        
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        
        
        logger.info("Calling getFortune() Method");
        
        String data = trafficFortuneService.getFortune();
        
        logger.info("My Fortune is :" + data);
        
        logger.info("Finished");
        context.close();
    }
}
