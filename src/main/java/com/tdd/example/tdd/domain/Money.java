package com.tdd.example.tdd.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class Money {
    public int amount;

    public Money(int amount) {
        this.amount = amount;
    }
    public Money times(int multiplier){
        return new Money(this.amount * multiplier);
    }
}
