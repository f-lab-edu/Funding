package com.flab.funding.domain.funding.repository;

import com.flab.funding.domain.funding.model.FundingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundingJpaRepository extends JpaRepository<FundingInfo, Long> {


}
