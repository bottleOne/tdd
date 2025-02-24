package com.tdd.example.tdd;

import com.tdd.example.tdd.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * $5 + 10CHF = $10(ghksdbfdl 2:1일 경우)
 * $5 * 2 = $10 ->해결
 * amount를 PRIVATE로 만들기
 * Money의 부작용?->해결
 * Money 반올림?
 * equals
 */
@SpringBootTest
public class testMoney {

    /**
     * 실제 코드를 작성하기전에 먼저 테스트 코드를 작성한다.
     */
    @Test
    public void testMultiaplication() {
        Money money = new Money(5);
        Money money1 = money.times(2);
        assertEquals(10,money1.amount);
        money1 = money.times(3);
        assertEquals(15,money1.amount);

    }
}
