package com.tdd.example.tdd;

import com.tdd.example.tdd.test2.WasRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testWasRun {

    @Test
    void testWasRun() {

        WasRun test = new WasRun("testMethod");
        Assertions.assertEquals(test.wasRun,false);
        test.run();
        Assertions.assertEquals(test.wasRun,true);;
    }

    @Test
    void testSetup() {

        WasRun test = new WasRun("testMethod");
        test.run();
        Assertions.assertEquals(test.wasSetUp,true);;
    }
}
