package com.flab.funding.domain.funding.controller;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.service.OrdererService;
import com.flab.funding.domain.funding.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class FundingController {

    private final SellerService sellerService;
    private final OrdererService ordererService;

    @PostMapping("/")
    public FundingInfo addFunding(@RequestBody FundingInfo fundingInfo) {
        return sellerService.addFunding(fundingInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteSellerFunding(@PathVariable Long id) {
        sellerService.deleteFunding(id);
    }

    @GetMapping("/seller/{id}")
    public Page<FundingInfo> getSellerFundingList(@PathVariable Long id, @RequestParam int page) {
        PageRequest pageReq = PageRequest.of(page, 10);
        return sellerService.getFundingList(id, pageReq);
    }

    @GetMapping("/seller/detail/{id}")
    public FundingInfo getSellerFundingDetail(@PathVariable Long id) {
        return sellerService.getFundingDetail(id);
    }
}
