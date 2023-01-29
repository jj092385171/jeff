package com.campingmapping.team4.spring.utils.oauth2.authaccount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.utils.oauth2.OAuth2Request;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.entity.AuthAccount;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.repository.AuthAccountRepository;

import jakarta.persistence.EntityNotFoundException;

import java.security.Principal;
import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
  private final AuthAccountRepository authAccountRepository;
  private final MemberService memberService;

  public AuthAccount findByAccountId(String accountId) {
    return authAccountRepository
        .findByAccountId(accountId)
        .orElseThrow(EntityNotFoundException::new);
  }

  private boolean isExistByAccountId(String accountId) {
    return authAccountRepository.existsByAccountId(accountId);
  }

  @Transactional
  public AuthAccount createIfFirst(OAuth2Request oAuth2Request) {
    String accountId = oAuth2Request.getAccountId();
    if (isExistByAccountId(accountId)) {
      return findByAccountId(accountId);
    }
    Member member = setUpMember(oAuth2Request);
    memberService.save(member);
    AuthAccount authAccount = setUpAuthAccount(oAuth2Request, member);
    authAccountRepository.save(authAccount);

    return authAccount;
  }

  public Collection<? extends GrantedAuthority> getAuthority(UUID id) {
    return getEntity(id).getRole();
  }

  private AuthAccount setUpAuthAccount(OAuth2Request oAuth2Request, Member member) {
    return AuthAccount.builder()
        .accountId(oAuth2Request.getAccountId())
        .authProvider(oAuth2Request.getProvider())
        .member(member)
        .build();
  }

  public Member getLoginUser(Principal principal) {
    return getEntity(UUID.fromString(principal.getName())).getMember();
  }

  private Member setUpMember(OAuth2Request oAuth2Request) {
    Member.MemberBuilder memberBuilder = Member.builder();

    oAuth2Request
        .getName()
        .ifPresent(
            n -> {
              memberBuilder.name(n);
              memberBuilder.nickname(n);
            });
    oAuth2Request.getEmail().ifPresent(memberBuilder::email);

    return memberBuilder.build();
  }

  private AuthAccount getEntity(UUID id) {
    return authAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
