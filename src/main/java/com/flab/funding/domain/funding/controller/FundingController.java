package com.flab.funding.domain.funding.controller;

import com.flab.funding.common.annotation.AuthRequired;
import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.service.OrdererService;
import com.flab.funding.domain.funding.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import static com.flab.funding.domain.user.model.UserRole.SELLER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class FundingController {

    private final SellerService sellerService;
    private final OrdererService ordererService;

    @AuthRequired(acceptRole = {SELLER})
    @PostMapping("/")
    public FundingInfo addFunding(@RequestBody FundingInfo fundingInfo) {
        return sellerService.addFunding(fundingInfo);
    }

    @AuthRequired(acceptRole = {SELLER})
    @DeleteMapping("/{id}")
    public void deleteSellerFunding(@PathVariable Long id) {
        sellerService.deleteFunding(id);
    }

    @AuthRequired(acceptRole = {SELLER})
    @GetMapping("/seller/{id}")
    public Page<FundingInfo> getSellerFundingList(@PathVariable Long id, @RequestParam int page) {
        PageRequest pageReq = PageRequest.of(page, 10);
        return sellerService.getFundingList(id, pageReq);
    }

    @AuthRequired(acceptRole = {SELLER})
    @GetMapping("/seller/detail/{id}")
    public FundingInfo getSellerFundingDetail(@PathVariable Long id) {
        return sellerService.getFundingDetail(id);
    }
}
