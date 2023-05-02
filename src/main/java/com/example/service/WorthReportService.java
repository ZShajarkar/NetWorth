package com.example.service;

import com.example.dto.WealthDto;
import com.example.entity.Asset;
import com.example.entity.Liability;
import com.example.repository.UserRepository;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorthReportService implements WealthServiceImpl {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public WealthDto calculateNetWorth(String token) {
        final Long userId = jwtTokenUtil.getUserIdFromToken(token);
        final List<Object[]> assetAndLiabilityBYUserId = userRepository.getAssetAndLiabilityBYUserId(userId);
        final BigDecimal totalLiability = getTotalLiability(getLiabilityFromObjectArray(assetAndLiabilityBYUserId.get(0)));
        final BigDecimal totalAsset = getTotalAsset(getAssetsFromObjectArray(assetAndLiabilityBYUserId.get(0)));
        final WealthDto wealthDto = new WealthDto();
        final BigDecimal netWealth = totalAsset.subtract(totalLiability);
        return wealthDto.setTotalAsset(totalAsset).setTotalLiability(totalLiability).setNetWealth(netWealth);
    }

    public Asset getAssetsFromObjectArray(Object[] objects) {
        return (Asset) objects[0];
    }

    public Liability getLiabilityFromObjectArray(Object[] objects) {
        return (Liability) objects[1];
    }

    private BigDecimal getTotalAsset(Asset asset) {
        return asset.getCars().add(asset.getCheckingAccounts()).add(asset.getRealState()).add(asset.getRetirementAccounts()).add(asset.getOtherAssets()).add(asset.getSavingAccounts());
    }

    private BigDecimal getTotalLiability(Liability liability) {
        return liability.getCarLoans().add(liability.getLoans()).add(liability.getCreditCardDebt()).add(liability.getOtherDebt()).add(liability.getPersonalLoans()).add(liability.getStudentLoans());
    }


}
