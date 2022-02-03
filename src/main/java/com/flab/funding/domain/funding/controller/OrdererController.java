package com.flab.funding.domain.funding.controller;

import com.flab.funding.common.annotation.AuthRequired;
import com.flab.funding.domain.funding.model.dto.OrderReq;
import com.flab.funding.domain.funding.model.dto.OrderRes;
import com.flab.funding.domain.funding.service.OrdererService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.flab.funding.domain.user.model.UserRole.ORDERER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund")
public class OrdererController {

    private final OrdererService ordererService;

    @AuthRequired(acceptRole = {ORDERER})
    @PostMapping("/order")
    public OrderRes orderFunding(@RequestBody OrderReq orderReq) {
        return ordererService.orderFunding(orderReq);
    }

    @AuthRequired(acceptRole = {ORDERER})
    @DeleteMapping("/order/{id}")
    public void refundFunding(@PathVariable Long id) {
        ordererService.refundFunding(id);
    }

    @AuthRequired(acceptRole = {ORDERER})
    @GetMapping("/order/{id}")
    public Slice<OrderRes> getOrderList(@PathVariable Long id
            , @PageableDefault(sort ="cretDt",  direction = Sort.Direction.DESC) Pageable pageable) {
        return ordererService.getOrderList(id);
    }

    @AuthRequired(acceptRole = {ORDERER})
    @GetMapping("/order/detail/{id}")
    public OrderRes getOrderDetail(@PathVariable Long id) {
        return ordererService.getOrderDetail(id);
    }
}