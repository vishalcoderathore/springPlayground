package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PackmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args){
        var marioGame = new MarioGame();
        var contraGame = new SuperContraGame();
        var packmanGame = new PackmanGame();
         
        var marioRunner = new GameRunner(marioGame);
        var contraRunner = new GameRunner(contraGame);
        var gameRunner = new GameRunner(packmanGame);
        
        marioRunner.run();
        contraRunner.run();
        gameRunner.run();

    }


    
}