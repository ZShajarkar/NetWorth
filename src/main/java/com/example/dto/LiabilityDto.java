package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class LiabilityDto {
    private BigDecimal loans;
    private BigDecimal creditCardDebt;
    private BigDecimal personalLoans;
    private BigDecimal studentLoans;
    private BigDecimal carLoans;
    private BigDecimal otherDebt;
    private UserDto user;
    private Long id;
}
