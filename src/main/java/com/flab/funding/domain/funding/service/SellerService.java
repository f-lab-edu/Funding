package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.exception.NoFundingExistException;
import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.repository.FundingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final FundingJpaRepository fundingJpaRepo;

    public FundingInfo addFunding(FundingInfo fundingInfo) {
        return fundingJpaRepo.save(fundingInfo);
    }

    public void deleteFunding(Long id) {
        fundingJpaRepo.deleteById(id);
    }

    public Page<FundingInfo> getFundingList(Long id, Pageable pageReq) {
        return fundingJpaRepo.findBySeller_Id(id, pageReq);
    }

    public FundingInfo getFundingDetail(Long id) {

        Optional<FundingInfo> fundingInfo = fundingJpaRepo.findById(id);

        if(fundingInfo.isEmpty()) throw new NoFundingExistException();

        return fundingInfo.get();
    }
}
