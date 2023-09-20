package com.in28minutes.learnspringframework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GameRunnerInterface;
import com.in28minutes.learnspringframework.game.PackmanGame;

@Configuration
class GamingConfiguration {
    // Creating a Packman bean
    @Bean
    public GameRunnerInterface game(){
        var game = new PackmanGame();
        return game;
    }

    // Wiring Packman bean to GameRunner
    @Bean
    public GameRunner gameRunner(GameRunnerInterface game){
        var gameRunner = new GameRunner((game));
        return gameRunner;
    }

    // game and gameRunner are Spring Beans
}

public class App3GamingSpringBeans {
 
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            
            // Picking and running Spring beans from Spring Context
            context.getBean(GameRunnerInterface.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}