package com.flab.funding.domain.funding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class ItemOption {

    // pk
    private Long id;

    // 펀딩 id
    private Long fundingId;

    // 아이템 이름
    private String itemName;

    // 아이템 가격
    private int itemPrice;

    // 아이템 수량
    private int quantity;
}
