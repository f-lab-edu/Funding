package com.flab.funding.domain.funding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
public class FundingInfo {

    // pk
    private Long id;

    // 펀딩 타이틀
    private String fundingTitle;

    // 펀딩 설명
    private String fundingDesc;

    // 펀딩 시작날짜
    private Date startDt;

    // 펀딩 목표날짜
    private Date targetDt;

    // 펀딩 목표금액
    private BigDecimal targetPrice;

    // 펀딩 상품 선택 옵션리스트
    private ArrayList<ItemOption> optionList;

    // 펀딩 상태 (진행중 / 취소 / 성공 / 실패)
    private FundingStatus fundingStatus;
}
