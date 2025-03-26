package com.tdd.example.tdd;

import com.tdd.example.tdd.test2.WasRun;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testWasRun {
    private WasRun test;
    @Test
    @Order(1)
    @BeforeEach
    void setup() {
        test = new WasRun("testMethod");
    }
    @Test
    @Order(2)
    void testWasRun() {
        test.run();
        Assertions.assertEquals(test.wasRun,true);;
    }

    @Test
    @Order(3)
    void testSetup() {
        test.run();
        Assertions.assertEquals(test.log,"setUp testMethod");;
    }

    @Test
    @Order(4)
    void testTemplateMethod(){
        test = new WasRun("testMethod");
        test.run();
        Assertions.assertEquals(test.log,"setUp testMethod tearDown ");
    }
}
