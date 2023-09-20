package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GameRunnerInterface game;
    public GameRunner(GameRunnerInterface game){
        this.game = game;
    }

    public void run(){
            System.out.println("Running game : " + game);
            game.up();
            game.down();
            game.left();
            game.right();
            
    }
}