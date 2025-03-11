package com.tdd.example.tdd;

import com.tdd.example.tdd.test2.WasRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testWasRun {

    @Test
    void testWasRun() {

        WasRun test = new WasRun();
        Assertions.assertEquals(test.wasRun,false);
        test.testMethod();
        Assertions.assertEquals(test.wasRun,true);;
    }
}
