package com.tdd.example.tdd.domain;

import com.tdd.example.tdd.expresion.Expression;
import com.tdd.example.tdd.expresion.Sum;

public class Bank {
    public Money reduce(Expression source, String to){
        return source.reduce(to);
    }
}
