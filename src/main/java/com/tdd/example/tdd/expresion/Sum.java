package com.tdd.example.tdd.expresion;

import com.tdd.example.tdd.domain.Money;

public class Sum implements Expression{
   public Money augend;
   public Money addend;
    public Sum(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to){
        int amount = augend.amount + this.addend.amount;
        return new Money(amount, to);
    }

}


