package com.tdd.example.tdd.expresion;

import com.tdd.example.tdd.domain.Money;

public interface Expression {
    public Money reduce(String to);
}
