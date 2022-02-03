package com.flab.funding.domain.funding.controller;

import com.flab.funding.common.annotation.AuthRequired;
import com.flab.funding.domain.funding.model.Funding;
import com.flab.funding.domain.funding.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.flab.funding.domain.user.model.UserRole.SELLER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class SellerController {

    private final SellerService sellerService;

    @AuthRequired(acceptRole = {SELLER})
    @PostMapping("/")
    public Funding addFunding(@RequestBody Funding fundingInfo) {
        return sellerService.addFunding(fundingInfo);
    }

    @AuthRequired(acceptRole = {SELLER})
    @DeleteMapping("/{id}")
    public void deleteSellerFunding(@PathVariable Long id) {
        sellerService.deleteFunding(id);
    }

    @AuthRequired(acceptRole = {SELLER})
    @GetMapping("/seller/{id}")
    public Slice<Funding> getSellerFundingList(@PathVariable Long id
            , @PageableDefault(sort ="startDt",  direction = Sort.Direction.DESC) Pageable pageable) {
        return sellerService.getFundingList(id, pageable);
    }

    @AuthRequired(acceptRole = {SELLER})
    @GetMapping("/seller/detail/{id}")
    public Funding getSellerFundingDetail(@PathVariable Long id) {
        return sellerService.getFundingDetail(id);
    }
}
