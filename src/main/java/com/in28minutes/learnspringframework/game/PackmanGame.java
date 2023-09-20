package com.in28minutes.learnspringframework.game;

public class PackmanGame implements GameRunnerInterface{
    public void up(){
        System.out.println("Packman UP");
    }

    public void down(){
        System.out.println("Packman Down");
    }

    public void left(){
        System.out.println("Packman Move backwards");
    }

    public void right(){
        System.out.println("Packman Move forward");
    }
}