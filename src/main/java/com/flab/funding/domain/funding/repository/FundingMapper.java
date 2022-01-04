package com.flab.funding.domain.funding.repository;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.model.ItemOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface FundingMapper {

    void insertFundingInfo(FundingInfo fundingInfo);
    void insertOptionItem(@Param("id") Long id, @Param("optionList") ArrayList<ItemOption> optionList);
}
