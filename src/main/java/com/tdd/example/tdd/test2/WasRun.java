package com.tdd.example.tdd.test2;

public class WasRun {

    public boolean wasRun;
    public String name;
    public WasRun(String name){
        this.wasRun = false;
        this.name = name;
    }

    public void testMethod() {
        this.wasRun = true;
    }

    public void run(){
        testMethod();
    }

}
