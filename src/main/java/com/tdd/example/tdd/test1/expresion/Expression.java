package com.tdd.example.tdd.test1.expresion;

import com.tdd.example.tdd.test1.domain.Bank;
import com.tdd.example.tdd.test1.domain.Money;

public interface Expression {
    public Money reduce(Bank bank, String to);
    public Expression plus(Expression addend);
    public Expression times(int multiplier);
}
