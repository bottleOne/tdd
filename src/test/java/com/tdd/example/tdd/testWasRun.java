package com.tdd.example.tdd;

import com.tdd.example.tdd.test2.TestResult;
import com.tdd.example.tdd.test2.TestSuite;
import com.tdd.example.tdd.test2.WasRun;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testWasRun {
    private WasRun test;
    @Test
    @Order(1)
    //@BeforeEach
    void setup() {
        test = new WasRun("testMethod");
    }

    @Test
    void testWasRun() {
        test.run(new TestResult());
        Assertions.assertEquals(test.wasRun,true);;
    }

    @Test
    void testSetup() {
        test.run(new TestResult());
        Assertions.assertEquals(test.log,"setUp testMethod");;
    }

    @Test
    void testTemplateMethod(){
        test = new WasRun("testMethod");
        test.run(new TestResult());
        Assertions.assertEquals(test.log,"setUp testMethod tearDown ");
    }

    @Test
    void testFailedResult(){
        test = new WasRun("testBrokenMethod");
        TestResult result = test.run(new TestResult());
        Assertions.assertEquals("1 run, 1 failed", result.summary());
    }

    @Test
    void testFailedResultFormatting(){
        TestResult testResult = new TestResult();
        testResult.testStarted();
        testResult.testFailed();
        Assertions.assertEquals("1 run, 1 failed", testResult.summary());
    }

    @Test
    void testSuite(){
        TestSuite testsuite = new TestSuite();
        testsuite.add(new WasRun("testMethod"));
        testsuite.add(new WasRun("testBrokenMethod"));
        TestResult result = testsuite.run();
        Assertions.assertEquals("2 run, 1 failed", result.summary());
    }
}
