package com.tdd.example.tdd.domain;

public class Money {
    protected int amount;
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
        return new Dollar(amount,"USD");
    }
    public static Money franc(int amount){
        return new Franc(amount,"CHF");
    }
    public String currency(){
        return this.currency;
    }
    public Money times(int multiplier){
        return new Money(this.amount * multiplier,  currency);
    }

    public String toString(){
        return amount + "   " + currency;
    }
}
