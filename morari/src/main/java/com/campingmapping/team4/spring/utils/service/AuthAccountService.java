package com.campingmapping.team4.spring.utils.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.OAuth2Request;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
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

  public UserProfiles findByEmail(String email) {

    return userRepository
        .findByEmail(email)
        .orElseThrow(EntityNotFoundException::new);
  }

  private boolean isExistByEmail(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Transactional
  public UserProfiles createIfFirst(OAuth2Request oAuth2Request) {
    String email = oAuth2Request.email();
    if (isExistByEmail(email)) {
      return findByEmail(email);
    }
    UserProfiles userProfiles = setUpUserProfiles(oAuth2Request);
    return userProfiles;
  }

  public Collection<? extends GrantedAuthority> getAuthority(UUID id) {
    return getEntity(id).getAuthorities();
  }

  public UserProfiles getLoginUser(Principal principal) {
    return getEntity(UUID.fromString(principal.getName()));
  }

  private UserProfiles setUpUserProfiles(OAuth2Request oAuth2Request) {
    UserProfiles user = UserProfiles.builder()
        .email(oAuth2Request.email())
        .uid(UUID.randomUUID())
        .build();
    UserDetail userDetail = new UserDetail();
    oAuth2Request.name().ifPresent(
        name -> {
          userDetail.setNickname(name);
          user.setUserddetail(userDetail);
        });
    oAuth2Request.shot().ifPresent(
        shot -> {
          userDetail.setShot(shot);
          user.setUserddetail(userDetail);
        });
    ;
    userRepository.save(user);
    return user;
  }

  private UserProfiles getEntity(UUID id) {
    return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
