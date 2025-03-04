package com.tdd.example.tdd.domain;

import com.tdd.example.tdd.expresion.Expression;
import com.tdd.example.tdd.expresion.Sum;

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
    public Money reduce(String to){
        return null;
    }
    public Expression plus(Money addend){
       return new Sum(this, addend);
    }
    public Money times(int multiplier) {
        return new Money(this.amount * multiplier,  currency);
    }

    public String toString(){
        return amount + "   " + currency;
    }

}
