package com.example.dto;

import java.math.BigDecimal;

public class WealthDto {
    private BigDecimal totalLiability;
    private BigDecimal totalAsset;
    private BigDecimal netWealth;

    public BigDecimal getTotalLiability() {
        return totalLiability;
    }

    public WealthDto setTotalLiability(BigDecimal totalLiability) {
        this.totalLiability = totalLiability;
        return this;
    }

    public BigDecimal getTotalAsset() {
        return totalAsset;
    }

    public WealthDto setTotalAsset(BigDecimal totalAsset) {
        this.totalAsset = totalAsset;
        return this;
    }

    public BigDecimal getNetWealth() {
        return netWealth;
    }

    public WealthDto setNetWealth(BigDecimal netWealth) {
        this.netWealth = netWealth;
        return this;
    }
}
