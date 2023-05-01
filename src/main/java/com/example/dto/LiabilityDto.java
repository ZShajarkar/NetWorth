package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class LiabilityDto {
    private BigDecimal loans=BigDecimal.ZERO;
    private BigDecimal creditCardDebt=BigDecimal.ZERO;
    private BigDecimal personalLoans=BigDecimal.ZERO;
    private BigDecimal studentLoans=BigDecimal.ZERO;
    private BigDecimal carLoans=BigDecimal.ZERO;
    private BigDecimal otherDebt=BigDecimal.ZERO;
    private UserDto user;
    private Long id;
}
