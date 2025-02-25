package com.tdd.example.tdd;

import com.tdd.example.tdd.domain.Dollar;
import com.tdd.example.tdd.domain.Franc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * $5 + 10CHF = $10(ghksdbfdl 2:1일 경우)
 * $5 * 2 = $10 ->해결
 * amount를 PRIVATE로 만들기--해결
 * Money의 부작용?->해결
 * Money 반올림?
 * equals -- 해결
 * equals null
 * equals object
 * Dollar/Franc 중복
 * 공용 equal --해결
 * 공용 times
 * Dollar/Franc 비교 --해결
 * 통화
 */
@SpringBootTest
public class testDollar {

    /**
     * 실제 코드를 작성하기전에 먼저 테스트 코드를 작성한다.
     */
    @Test
    public void testMultiaplication() {
        Dollar dollar = new Dollar(5);
        assertEquals(new Dollar(10) ,dollar.times(2));
        assertEquals(new Dollar(15), dollar.times(3));

    }

    /**
     * 중복
     */
    @Test
    public void testFrancMultiaplication() {
        Franc franc = new Franc(5);
        assertEquals(new Franc(10) ,franc.times(2));
        assertEquals(new Franc(15), franc.times(3));

    }

    /**
     * EQUALS공통화
     */
    @Test
    public void testEquals() {
        assertTrue(new Dollar(10) .equals(new Dollar(10)));
        assertFalse(new Dollar(10) .equals(new Dollar(11)));
        assertTrue(new Franc(10) .equals(new Franc(10)));
        assertFalse(new Franc(10) .equals(new Franc(11)));
        assertFalse(new Franc(10) .equals(new Dollar(10)));
    }
}
