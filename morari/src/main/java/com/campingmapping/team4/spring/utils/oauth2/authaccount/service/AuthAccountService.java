package com.campingmapping.team4.spring.utils.oauth2.authaccount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles.UserProfilesBuilder;
import com.campingmapping.team4.spring.utils.oauth2.OAuth2Request;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.entity.AuthAccount;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.repository.AuthAccountRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.security.Principal;
import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
  // private final AuthAccountRepository authAccountRepository;
  private final UserRepository userRepository;

  // private final MemberService memberService;

  public UserProfiles findByAccountId(String accountId) {
    return userRepository
        .findByAccountId(accountId)
        .orElseThrow(EntityNotFoundException::new);
  }

  private boolean isExistByAccountId(String accountId) {
    return userRepository.existsByAccountId(accountId);
  }

  @Transactional
  public UserProfiles createIfFirst(OAuth2Request oAuth2Request) {
    String accountId = oAuth2Request.accountId();
    if (isExistByAccountId(accountId)) {
      return findByAccountId(accountId);
    }

    UserProfiles userProfiles = setUpUserProfiles(oAuth2Request);
    memberService.save(member);
    AuthAccount authAccount = setUpAuthAccount(oAuth2Request, member);
    

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

  private UserProfiles setUpUserProfiles(OAuth2Request oAuth2Request) {
    UserProfilesBuilder userBuilder = UserProfiles.builder();
    oAuth2Request.email().ifPresent(userBuilder::email);
    UserProfiles user = userBuilder.build();
    oAuth2Request
    .name()
    .ifPresent(
        n -> {          
          UserDetail.builder().nickname(n).build();
                  });


    userRepository.save(user);

    return user;
  }

  private AuthAccount getEntity(UUID id) {
    return authAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
