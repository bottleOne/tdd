package com.tdd.example.tdd.test2;

public abstract class TestCase {

    public String name;
    public TestCase(String name){
    this.name = name;
}
    public TestResult run(TestResult result){
        result.testStarted();
        setUp();

        try {
            if(name.equals("testMethod")){
                testMethod();
            } else if (name.equals("testBrokenMethod")) {
                testBrokenMethod();
            }
        }catch (Exception e){
            result.testFailed();
        }

        tearDown();
        return result;
    }

    public abstract  void testBrokenMethod();
    public abstract void testMethod();
    public abstract void setUp();
    public abstract void tearDown();
}
