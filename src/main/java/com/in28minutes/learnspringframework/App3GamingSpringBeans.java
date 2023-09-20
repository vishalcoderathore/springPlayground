package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GameRunnerInterface;

public class App3GamingSpringBeans {
 
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            
            // Picking and running Spring beans from Spring Context
            context.getBean(GameRunnerInterface.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}