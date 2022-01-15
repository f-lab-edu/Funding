package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.repository.FundingJpaRepository;
import com.flab.funding.domain.funding.repository.FundingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final FundingJpaRepository fundingJpaRepo;

    public Optional<FundingInfo> addFunding(FundingInfo fundingInfo) {

        fundingJpaRepo.save(fundingInfo);

        return Optional.of(fundingInfo);
    }
}
