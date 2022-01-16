package com.flab.funding.domain.funding.repository;

import com.flab.funding.domain.funding.model.FundingInfo;
import com.flab.funding.domain.funding.model.ItemOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.flab.funding.domain.funding.model.FundingStatus.ING;

@DataJpaTest
public class FundingJpaTest {

    @Autowired
    FundingJpaRepository fundingJpaRepo;

    @Test
    @DisplayName("SELLER의 신규 펀딩상품 등록 insert query 테스트")
    void insertFundingInfoTest() {

        // given
        FundingInfo insertFundingInfo = testFundingInfo();

        // when
        FundingInfo resFundingInfo = fundingJpaRepo.save(testFundingInfo());

        // then
        Assertions.assertEquals(insertFundingInfo.getFundingTitle(), resFundingInfo.getFundingTitle());
        Assertions.assertEquals(insertFundingInfo.getOptionList().get(0).getItemName(), resFundingInfo.getOptionList().get(0).getItemName());

    }

    private FundingInfo testFundingInfo() {
        return FundingInfo.builder()
//                .id(1L)
                .fundingTitle("Funding Item1")
                .fundingDesc("Description of Sample Funding Item")
                .startDt(LocalDate.of(2022,1,4))
                .targetDt(LocalDate.of(2022,1,31))
                .targetPrice(1000000)
                .fundingStatus(ING)
                .optionList(testOptionList())
                .build();
    }

    private List<ItemOption> testOptionList() {
        var item1 = ItemOption.builder()
//                .id(1L)
                .itemName("Item Option1")
                .itemPrice(9900)
                .build();

        var item2 = ItemOption.builder()
//                .id(2L)
                .itemName("Item Option2")
                .itemPrice(5000)
                .build();

        List<ItemOption> optionList = new ArrayList<>();
        optionList.add(item1);
        optionList.add(item2);

        return optionList;
    }
}
