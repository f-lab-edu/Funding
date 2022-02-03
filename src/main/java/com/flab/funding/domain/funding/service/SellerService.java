package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.exception.NoFundingExistException;
import com.flab.funding.domain.funding.model.Funding;
import com.flab.funding.domain.funding.repository.FundingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final FundingJpaRepository fundingJpaRepo;

    public Funding addFunding(Funding fundingInfo) {
        return fundingJpaRepo.save(fundingInfo);
    }

    public void deleteFunding(Long id) {
        fundingJpaRepo.deleteById(id);
    }

    public Slice<Funding> getFundingList(Long id, Pageable pageable) {
        return fundingJpaRepo.findBySeller_Id(id, pageable);
    }

    public Funding getFundingDetail(Long id) {

        Optional<Funding> fundingInfo = fundingJpaRepo.findById(id);

        return fundingInfo.orElseThrow(NoFundingExistException::new);
    }
}
