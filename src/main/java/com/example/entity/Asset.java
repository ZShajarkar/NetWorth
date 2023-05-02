package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "assets")
public class Asset {
    private BigDecimal realState;
    private BigDecimal checkingAccounts;
    private BigDecimal savingAccounts;
    private BigDecimal retirementAccounts;
    private BigDecimal cars;
    private BigDecimal otherAssets;
    @OneToOne
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}