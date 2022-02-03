package com.flab.funding.domain.funding.controller;

import com.flab.funding.common.annotation.AuthRequired;
import com.flab.funding.domain.funding.model.Funding;
import com.flab.funding.domain.funding.service.FundingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.flab.funding.domain.user.model.UserRole.ORDERER;
import static com.flab.funding.domain.user.model.UserRole.SELLER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class FundingController {

    private final FundingService fundingService;

    @AuthRequired(acceptRole = {SELLER, ORDERER})
    @GetMapping("/")
    public Slice<Funding> getFundingList(@PageableDefault(sort ="startDt", direction = Sort.Direction.DESC) Pageable pageable) {
        return fundingService.getFundingList(pageable);
    }

    @AuthRequired(acceptRole = {SELLER, ORDERER})
    @GetMapping("/{id}")
    public Funding getFundingDetail(@PathVariable Long id) {
        return fundingService.getFundingDetail(id);
    }

}
