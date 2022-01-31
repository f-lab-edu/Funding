package com.flab.funding.domain.funding.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class OrderReq {

    private long ordererId;

    private long fundingId;

    private List<OrderDetailDto> orderDetails = new ArrayList<>();
}
