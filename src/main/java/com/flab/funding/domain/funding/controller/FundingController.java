package com.flab.funding.domain.funding.controller;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class FundingController {

    private final SellerService sellerService;

    @PostMapping("/")
    public ResponseEntity<FundingInfo> addFunding(@RequestBody FundingInfo fundingInfo) {
        return ResponseEntity.of(sellerService.addFunding(fundingInfo));
    }
}
