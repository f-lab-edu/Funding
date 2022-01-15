package com.flab.funding.domain.funding.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@Entity
public class FundingInfo {

    // pk
    @Id @GeneratedValue
    private Long id;

    // 펀딩 타이틀
    private String fundingTitle;

    // 펀딩 설명
    private String fundingDesc;

    // 펀딩 시작날짜
    private LocalDate startDt;

    // 펀딩 목표날짜
    private LocalDate targetDt;

    // 펀딩 목표금액
    private int targetPrice;

    // 펀딩 상품 선택 옵션리스트
    @OneToMany(mappedBy="fundingInfo", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemOption> optionList;

    // 펀딩 상태 (진행중 / 취소 / 성공 / 실패)
    private FundingStatus fundingStatus;
}
