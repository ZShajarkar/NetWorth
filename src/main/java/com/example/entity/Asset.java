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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal realState;
    private BigDecimal checkingAccounts;
    private BigDecimal savingAccounts;
    private BigDecimal retirementAccounts;
    private BigDecimal cars;
    private BigDecimal otherAssets;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private User user;

}
