package com.flab.funding.domain.funding.repository;

import com.flab.funding.domain.funding.model.Funding;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundingJpaRepository extends JpaRepository<Funding, Long> {

    Slice<Funding> findBySeller_Id(Long id, Pageable page);

}
