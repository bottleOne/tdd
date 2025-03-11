package com.tdd.example.tdd.test1.expresion;

import com.tdd.example.tdd.test1.domain.Bank;
import com.tdd.example.tdd.test1.domain.Money;

public class Sum implements Expression{
   public Expression augend;
   public Expression addend;
    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

}


