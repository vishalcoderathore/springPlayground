package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingApplicationLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingApplicationLauncherApplication.class)) {

            // Picking and running Spring beans from Spring Context
            context.getBean(GameRunnerInterface.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}