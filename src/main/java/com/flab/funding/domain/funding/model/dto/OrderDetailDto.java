package com.flab.funding.domain.funding.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDetailDto {

    private long option_id;

    private int unitPrice;

    private int count;
}