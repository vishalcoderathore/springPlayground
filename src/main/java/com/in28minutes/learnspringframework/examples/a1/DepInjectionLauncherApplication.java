package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Creating -> YourBusinessClass
@Component
class YourBusinessClass {
    Dependancy1 dependancy1;
    Dependancy2 dependancy2;

    // @Autowired // Setter based autowiring
    // public void setDependancy1(Dependancy1 dependancy1) {
    //     System.out.println("Setter injection for Depedancy 1");
    //     this.dependancy1 = dependancy1;
    // }

    // @Autowired //Setter based autowiring
    // public void setDependancy2(Dependancy2 dependancy2) {
    //     System.out.println("Setter injection for Depedancy 2");
    //     this.dependancy2 = dependancy2;
    // }

    //@Autowired // Autowired annotation is not mandatory for constructor based autowiring
    public YourBusinessClass(Dependancy1 dependancy1, Dependancy2 dependancy2) {
        super();
        System.out.println("Constructor based Autowiring");
        this.dependancy1 = dependancy1;
        this.dependancy2 = dependancy2;
    }

    public String toString() {
        return "Using " + dependancy1 + " and " + dependancy2;
    }
}

// Creating -> Dependancy1
@Component // Add this to make this class a bean
class Dependancy1 {
}

// Creating -> Dependancy2
@Component // Add this to make this class a bean
class Dependancy2 {
}

@Configuration
@ComponentScan // Add this to make this class a bean
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
