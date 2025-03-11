package com.tdd.example.tdd;


import com.tdd.example.tdd.test1.domain.Bank;
import com.tdd.example.tdd.test1.domain.Money;
import com.tdd.example.tdd.test1.expresion.Expression;
import com.tdd.example.tdd.test1.expresion.Sum;
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
 * equals null --해결
 * equals object --해결
 * Dollar/Franc 중복 --해결
 * 공용 equal --해결
 * 공용 times --해결
 * Dollar/Franc 비교 --해결
 * 통화 ---해결
 * SUM.PLUS --해결
 * EXPRESSION.TIMES --해결
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
        assertFalse(Money.franc(10) .equals(Money.dollar(10)));
    }

    /**
     * plus테스트
     */
    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"USD");
       assertEquals(Money.dollar(10),reduced);
    }

    /**
     * sum테스트
     */
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7),result);
    }

    /**
     * 환율적용
     */
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1,new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    /**
     * sum plus
     */
    @Test
    void testSumPlusTest() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    /**
     * sum times
     */
    @Test
    void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test
    void testPlusSameCurrencyReturnMoney() {
        Expression sum = Money.dollar(1).plus(Money.dollar(1));
        assertTrue(sum instanceof Money);
    }

}
