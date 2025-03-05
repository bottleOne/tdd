package com.tdd.example.tdd.expresion;

import com.tdd.example.tdd.domain.Bank;
import com.tdd.example.tdd.domain.Money;

public interface Expression {
    public Money reduce(Bank bank, String to);
}
