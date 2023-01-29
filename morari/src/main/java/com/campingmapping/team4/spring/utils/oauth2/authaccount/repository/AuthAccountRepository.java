package com.campingmapping.team4.spring.utils.oauth2.authaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campingmapping.team4.spring.utils.oauth2.authaccount.entity.AuthAccount;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthAccountRepository extends JpaRepository<AuthAccount, UUID> {
  Optional<AuthAccount> findByAccountId(String accountId);

  boolean existsByAccountId(String accountId);
}
