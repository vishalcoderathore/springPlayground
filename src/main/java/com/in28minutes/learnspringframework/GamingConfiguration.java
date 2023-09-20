package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GameRunnerInterface;
import com.in28minutes.learnspringframework.game.PackmanGame;

@Configuration
public class GamingConfiguration {
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