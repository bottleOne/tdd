package com.tdd.example.tdd.test2;

public class WasRun extends TestCase{

    public boolean wasRun;

    public boolean wasSetUp;
    public WasRun(String name) {
        super(name);
        this.wasRun = false;
        this.wasSetUp = false;
    }
    public void setUp(){
        this.wasSetUp = true;
        this.wasRun = true;
    }

    public void testMethod() {
        this.wasRun = true;
    }



}
