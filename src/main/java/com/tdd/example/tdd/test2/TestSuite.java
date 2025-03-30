package com.tdd.example.tdd.test2;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    public List<WasRun> tests;

    public TestSuite() {
        this.tests = new ArrayList<>();
    }

    public TestResult run(){
        TestResult result = new TestResult();
        tests.stream().forEach(t->t.run(result));
        return result;
    }
    public void add(WasRun test){
        this.tests.add(test);
    }

}
