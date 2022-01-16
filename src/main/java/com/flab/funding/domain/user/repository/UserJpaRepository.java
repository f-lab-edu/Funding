package com.flab.funding.domain.user.repository;

import com.flab.funding.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
