package com.example.service;

import com.example.entity.Asset;
import com.example.entity.Liability;
import com.example.repository.AssetRepository;
import com.example.repository.LiabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WorthReportService {
    private final AssetRepository assetRepository;
    private final LiabilityRepository liabilityRepository;

    @Autowired
    public WorthReportService(AssetRepository assetRepository, LiabilityRepository liabilityRepository) {
        this.assetRepository = assetRepository;
        this.liabilityRepository = liabilityRepository;
    }

    public BigDecimal calculateNetWorth(Long userId) {
        return getTotalAsset(userId).min(getTotalLiability(userId));
    }

    private BigDecimal getTotalAsset(Long userId) {
        final Asset byUserId = assetRepository.findByUserId(userId);
        return byUserId.getCars().add(byUserId.getCheckingAccounts()).add(byUserId.getRealState()).add(byUserId.getRetirementAccounts()).add(byUserId.getOtherAssets()).add(byUserId.getSavingAccounts());
    }

    private BigDecimal getTotalLiability(Long userId) {
        final Liability byUserId = liabilityRepository.findByUserId(userId);
        return byUserId.getCarLoans().add(byUserId.getLoans()).add(byUserId.getCreditCardDebt()).add(byUserId.getOtherDebt()).add(byUserId.getPersonalLoans()).add(byUserId.getStudentLoans());
    }

}
