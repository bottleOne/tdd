package com.tdd.example.tdd;

import com.tdd.example.tdd.domain.Dollar;
import com.tdd.example.tdd.domain.Franc;
import com.tdd.example.tdd.domain.Money;
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
 * 공용 times --해결
 * Dollar/Franc 비교 --해결
 * 통화 ---해결
 */
@SpringBootTest
public class testDollar {

    /**
     * 실제 코드를 작성하기전에 먼저 테스트 코드를 작성한다.
     */
    @Test
    public void testMultiaplication() {
        Money money = Money.dollar(5);
        assertEquals(Money.dollar(10) ,money.times(2));
        assertEquals(Money.dollar(15), money.times(3));
    }

    /**
     * 중복
     */
    @Test
    public void testFrancMultiaplication() {
        Money franc = Money.franc(5);
        assertEquals(Money.franc(10) ,franc.times(2));
        assertEquals(Money.franc(15), franc.times(3));

    }

    /**
     * EQUALS 공통화
     */
    @Test
    public void testEquals() {
        assertTrue(Money.dollar(10) .equals(Money.dollar(10)));
        assertFalse(Money.dollar(10) .equals(Money.dollar(11)));
        assertTrue(Money.franc(10) .equals(Money.franc(10)));
        assertFalse(Money.franc(10) .equals(Money.franc(11)));
        assertFalse(Money.franc(10) .equals(Money.dollar(10)));
    }

    /**
     * 통화확인
     */
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    /**
     * times 상위로 공통화
     */
    @Test
    public void testDifferentClassEquality(){
        assertTrue(new Money(10,"USD").equals(new Franc(10, "USD")));
    }
}
