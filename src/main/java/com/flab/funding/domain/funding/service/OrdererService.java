package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.model.FundingOrderInfo;
import com.flab.funding.domain.funding.model.OrderInfoDto;
import com.flab.funding.domain.funding.repository.FundingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdererService {

    private final FundingJpaRepository fundingJpaRepo;
    
    public FundingOrderInfo orderFunding(OrderInfoDto orderInfoDto) {
        return null;
    }

    public void refundFunding(Long id) {
    }

    public Slice<FundingOrderInfo> getOrderList(Long id) {
        return null;
    }

    public FundingOrderInfo getOrderDetail(Long id) {
        return null;
    }
}
