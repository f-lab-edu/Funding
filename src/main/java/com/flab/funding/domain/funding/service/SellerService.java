package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.repository.FundingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final FundingMapper fundingMapper;

    public Optional<FundingInfo> addFunding(FundingInfo fundingInfo) {

        // TODO: 트랜젝션처리
        // FundingInfo 데이터 추가
        fundingMapper.insertFundingInfo(fundingInfo);
        // FundingInfo에 매핑되는 OptionItem 데이터 추가
        fundingMapper.insertOptionItem(fundingInfo.getId(), fundingInfo.getOptionList());

        return Optional.of(fundingInfo);
    }
}
