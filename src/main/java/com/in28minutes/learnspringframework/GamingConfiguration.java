package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PackmanGame;

@Configuration
public class GamingConfiguration {
    @Bean
    public GameRunner game(){
        var game = new PackmanGame();
        return game;
    }
}