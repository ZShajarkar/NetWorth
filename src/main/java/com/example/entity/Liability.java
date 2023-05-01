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
    private BigDecimal loans= BigDecimal.valueOf(0);
    private BigDecimal creditCardDebt= BigDecimal.valueOf(0);
    private BigDecimal personalLoans= BigDecimal.valueOf(0);
    private BigDecimal studentLoans= BigDecimal.valueOf(0);
    private BigDecimal carLoans= BigDecimal.valueOf(0);
    private BigDecimal otherDebt= BigDecimal.valueOf(0);
    @OneToOne
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
