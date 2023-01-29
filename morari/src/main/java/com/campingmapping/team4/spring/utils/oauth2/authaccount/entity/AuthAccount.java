package com.campingmapping.team4.spring.utils.oauth2.authaccount.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthAccount {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  private String accountId;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

  @Enumerated(EnumType.STRING)
  private AuthProvider authProvider = AuthProvider.NONE;

  @OneToOne private Member member;

  private boolean isRegister = false;

  public void register(Member member) {
    this.member = member;
    isRegister = true;
  }

  public List<SimpleGrantedAuthority> getRole() {
    return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
  }

  @Builder
  public AuthAccount(String accountId, AuthProvider authProvider, Member member) {
    this.accountId = accountId;
    this.authProvider = authProvider;
    register(member);
  }
}
