package com.flab.funding.domain.funding.repository;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.model.ItemOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.flab.funding.domain.funding.model.FundingStatus.ING;

@MybatisTest
public class FundingMybatisTest {

    @Autowired
    FundingMapper fundingMapper;

    @Test
    @DisplayName("SELLER의 신규 펀딩상품 등록 insert query 테스트")
    void insertFundingInfoTest() {
        Assertions.assertEquals(1, fundingMapper.insertFundingInfo(testFundingInfo()));
    }

    @Test
    @DisplayName("SELLER의 신규 펀딩 옵션 아이템 insert query 테스트")
    void insertOptionItemTest() {
        Assertions.assertEquals(2, fundingMapper.insertOptionItem(1L, testOptionList()));

    }

    private FundingInfo testFundingInfo() {
        return FundingInfo.builder()
                .id(1L)
                .fundingTitle("Funding Item1")
                .fundingDesc("Description of Sample Funding Item")
                .startDt(LocalDate.of(2022,1,4))
                .targetDt(LocalDate.of(2022,1,31))
                .targetPrice(BigDecimal.valueOf(1000000))
                .fundingStatus(ING)
                .build();
    }

    private ArrayList<ItemOption> testOptionList() {
        var item1 = ItemOption.builder()
                                .id(1L)
                                .itemName("Item Option1")
                                .itemPrice(BigDecimal.valueOf(9900))
                                .build();

        var item2 = ItemOption.builder()
                                .id(2L)
                                .itemName("Item Option2")
                                .itemPrice(BigDecimal.valueOf(5000))
                                .build();

        ArrayList<ItemOption> optionList = new ArrayList<>();
        optionList.add(item1);
        optionList.add(item2);

        return optionList;
    }
}
