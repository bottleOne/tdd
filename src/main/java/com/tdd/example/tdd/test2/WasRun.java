package com.tdd.example.tdd.test2;


public class WasRun extends TestCase{

    public boolean wasRun;
    public String log;
    public boolean wasSetUp;
    public WasRun(String name) {
        super(name);
        this.wasRun = false;
        this.wasSetUp = false;
    }
    public void setUp(){
        this.wasSetUp = true;
        this.wasRun = false;
        this.log="setUp ";
    }

    public void testMethod() {
        this.wasRun = true;
        this.log = this.log + "testMethod";
    }



}
