package com.flab.funding.domain.funding.service;

import com.flab.funding.domain.funding.model.Order;
import com.flab.funding.domain.funding.model.dto.OrderReq;
import com.flab.funding.domain.funding.model.dto.OrderRes;
import com.flab.funding.domain.funding.repository.FundingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdererService {

    private final FundingJpaRepository fundingJpaRepo;
    
    public OrderRes orderFunding(OrderReq orderInfoDto) {
        return null;
    }

    public void refundFunding(Long id) {
    }

    public Slice<OrderRes> getOrderList(Long id) {
        return null;
    }

    public OrderRes getOrderDetail(Long id) {
        return null;
    }
}
