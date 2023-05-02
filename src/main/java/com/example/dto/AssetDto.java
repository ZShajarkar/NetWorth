package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AssetDto {
    private BigDecimal realState = BigDecimal.ZERO;
    private BigDecimal checkingAccounts = BigDecimal.ZERO;
    private BigDecimal savingAccounts = BigDecimal.ZERO;
    private BigDecimal retirementAccounts = BigDecimal.ZERO;
    private BigDecimal cars = BigDecimal.ZERO;
    private BigDecimal otherAssets = BigDecimal.ZERO;
    private UserDto user;
}
