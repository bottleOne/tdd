package com.tdd.example.tdd.test2;

public abstract class TestCase {

    public String name;
    public TestCase(String name){
    this.name = name;
}
    public void run(){
        setUp();
        if(name.equals("testMethod")){
            testMethod();
        }
        tearDown();
    }

    public abstract void testMethod();
    public abstract void setUp();

    public abstract void tearDown();
}
