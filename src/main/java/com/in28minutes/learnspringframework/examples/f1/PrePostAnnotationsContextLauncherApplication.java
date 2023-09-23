package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
    private SomeDependancy someDependancy;

    public SomeClass(SomeDependancy someDependancy){
        super();
        this.someDependancy = someDependancy;
        System.out.println("SomeClass Initialized ; Dependancies are met");
    }

    @PostConstruct
    public void initialize(){
        someDependancy.getReady();
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying now");
    }
}

@Component
class SomeDependancy{
    public void getReady(){
        System.out.println("SomeDepandancy is ready");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
          try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
