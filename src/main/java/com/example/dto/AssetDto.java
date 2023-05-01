package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AssetDto {
    private BigDecimal realState;
    private BigDecimal checkingAccounts;
    private BigDecimal savingAccounts;
    private BigDecimal retirementAccounts;
    private BigDecimal cars;
    private BigDecimal otherAssets;
    private UserDto user;
}
