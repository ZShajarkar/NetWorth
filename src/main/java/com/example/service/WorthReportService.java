package com.example.service;

import com.example.entity.Asset;
import com.example.entity.Liability;
import com.example.repository.AssetRepository;
import com.example.repository.LiabilityRepository;
import com.example.repository.UserRepository;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WorthReportService {
    private final AssetRepository assetRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final LiabilityRepository liabilityRepository;

    public BigDecimal calculateNetWorth(String token) {
        final Long userId = getUserIdFromToken(token);
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

    private Long getUserIdFromToken(String token) {
        final String userEmail = jwtTokenUtil.getUsernameFromToken(token);
        final Long userId = userRepository.findByEmail(userEmail).getId();
        return userId;
    }
}
