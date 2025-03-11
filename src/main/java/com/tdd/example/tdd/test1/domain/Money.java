package com.tdd.example.tdd.test1.domain;

import com.tdd.example.tdd.test1.expresion.Sum;
import com.tdd.example.tdd.test1.expresion.Expression;

public class Money implements Expression {
    public int amount;
    protected String currency;
    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount &&
                this.currency.equals(money.currency);
    }

    public static Money dollar(int amount){
        return new Money(amount,"USD");
    }
    public static Money franc(int amount){
        return new Money(amount,"CHF");
    }
    public String currency(){
        return this.currency;
    }
    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }
    public Expression plus(Expression addend){
       return new Sum(this, addend);
    }
    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier,  currency);
    }

    public String toString(){
        return amount + "   " + currency;
    }

}
