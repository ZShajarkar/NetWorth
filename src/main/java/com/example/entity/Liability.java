package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "liability")
@Setter
@Getter
public class Liability {
    private BigDecimal loans;
    private BigDecimal creditCardDebt;
    private BigDecimal personalLoans;
    private BigDecimal studentLoans;
    private BigDecimal carLoans;
    private BigDecimal otherDebt;
    @OneToOne
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
