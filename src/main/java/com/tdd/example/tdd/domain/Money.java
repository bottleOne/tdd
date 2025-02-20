package com.tdd.example.tdd.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Money {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id @Column(name = "money_id")
    private Long id;

    private String classType;

    private int ju;

    private int price;

    private int totalPrice;
}
