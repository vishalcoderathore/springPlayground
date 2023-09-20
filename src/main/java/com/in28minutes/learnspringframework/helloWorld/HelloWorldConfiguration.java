package com.in28minutes.learnspringframework.helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record  Person(String name, int age, Address address){}
record Address(String firstLine, String city){}

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Vishal, this is Configuration File";
    }
    
    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Raja", 20, new Address("some random street", "i dont know where"));
    }

    @Bean(name = "address2")
    public Address address(){
        return new Address("1036 17th Ave SE", "MSP");
    }

    // method call method
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), new Address("i told ya", "chap doesn't live here"));
    }

    // parameter way
    @Bean
    public Person person3ParametersCall(String name, int age, Address address2){
        // name, age, address2
        return new Person(name, age, address2);
    }   
}