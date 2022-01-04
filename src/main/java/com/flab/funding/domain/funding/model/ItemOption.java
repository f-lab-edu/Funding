package com.flab.funding.domain.funding.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ItemOption {

    // pk
    private Long id;

    // 아이템 이름
    private String itemName;

    // 아이템 가격
    private BigDecimal itemPrice;

    // 아이템 수량
    private int quantity;
}
