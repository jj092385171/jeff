package com.campingmapping.team4.spring.t401member.model.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t411team.model.entity.Initiating;
import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t436mall.model.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userprofiles")
@Component
public class UserProfiles implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer uid;
  private String account;
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  private Collection<Role> roles;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority(role.name()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return account;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  @Builder.Default
  private Set<Post> post = new LinkedHashSet<Post>();

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  @Builder.Default
  private Set<JobBean> job = new LinkedHashSet<JobBean>();

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  @Builder.Default
  private Set<Initiating> initiatings = new LinkedHashSet<Initiating>();

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  @Builder.Default
  private Set<Category> categories = new LinkedHashSet<Category>();

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  @Builder.Default
  private Set<LoginHistory> loginHistories = new LinkedHashSet<LoginHistory>();
}
