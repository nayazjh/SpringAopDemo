package com.nayaz.SpringAopDemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nayaz.SpringAopDemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp 
{
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(DemoConfig.class);
        
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        
        logger.info("Main Program : AroundHandleExceptionDemoApp");
        logger.info("Calling getFortune() Method");
        
        boolean value = true; 
        
        String data = trafficFortuneService.getFortune(value);
        
        logger.info("My Fortune is :" + data);
        
        logger.info("Finished");
        context.close();
    }
}
