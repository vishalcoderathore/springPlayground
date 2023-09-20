package com.in28minutes.learnspringframework.game;

public class MarioGame implements GameRunnerInterface{

    public void up(){
        System.out.println("Jump UP");
    }

    public void down(){
        System.out.println("Down");
    }

    public void left(){
        System.out.println("Move backwards");
    }

    public void right(){
        System.out.println("Move forward");
    }
    
}