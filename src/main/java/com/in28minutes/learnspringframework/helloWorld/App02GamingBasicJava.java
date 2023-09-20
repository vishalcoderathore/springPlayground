package com.in28minutes.learnspringframework.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingBasicJava {
 
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){

        // 2: Configure the things that we want the Spring to manage : @Configuration
        // HelloWorldConfiguration.java
        // name - @Bean

        // 3: Retrieving Beans managed by Spring
        System.out.println(context.getBean("name"));
        //context.getBean("name", args)
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3ParametersCall"));
        System.out.println(context.getBean(Address.class));

        // Get all the Beans
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
        
        
        
       
    }
}