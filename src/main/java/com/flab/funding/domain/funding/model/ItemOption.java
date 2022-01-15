package com.flab.funding.domain.funding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Getter
@Builder
@Entity
@NoArgsConstructor
public class ItemOption {

    // pk
    @Id @GeneratedValue
    private Long id;

    // 펀딩
    @ManyToOne
    private FundingInfo fundingInfo;

    // 아이템 이름
    private String itemName;

    // 아이템 가격
    private int itemPrice;

    // 아이템 수량
    private int quantity;
}
