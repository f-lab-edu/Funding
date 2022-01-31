package com.flab.funding.domain.funding.model.dto;

import com.flab.funding.domain.funding.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderRes {

    private long orderId;

    private String title;

    private List<OrderDetailDto> orderDetails = new ArrayList<>();

    private LocalDateTime orderDt;

    private int totalPrice;

    private OrderStatus orderStatus;
}
