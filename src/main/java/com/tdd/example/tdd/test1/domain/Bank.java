package com.tdd.example.tdd.test1.domain;

import com.tdd.example.tdd.test1.expresion.Pair;
import com.tdd.example.tdd.test1.expresion.Expression;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String to, String from, int rate){
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String to, String from) {
        if(to.equals(from)) return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }
}
