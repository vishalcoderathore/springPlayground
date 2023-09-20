package com.in28minutes.learnspringframework.game;

public class SuperContraGame implements GameRunnerInterface{

    public void up(){
        System.out.println("Contra Jump UP");
    }

    public void down(){
        System.out.println("Contra Sit Down");
    }

    public void left(){
        System.out.println("Contra Move backwards");
    }

    public void right(){
        System.out.println("Contra Move forward");
    }
    
}