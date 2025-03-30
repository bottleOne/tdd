package com.tdd.example.tdd.test2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestResult {

    public int runCount;
    public int failureCount;

    public TestResult(){
        this.runCount = 0;
        this.failureCount = 0;
    }
    public void testStarted(){
        this.runCount += 1;
    }

    public void testFailed(){
        this.failureCount += 1;
    }

    public String summary(){
        log.info("runcount = {}, failureCount = {}", this.runCount, this.failureCount);
        return String.valueOf(runCount) + " run, "+String.valueOf(failureCount) + " failed";
    }
}
