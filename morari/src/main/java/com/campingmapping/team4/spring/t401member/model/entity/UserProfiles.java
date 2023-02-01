package com.campingmapping.team4.spring.t401member.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;
import com.campingmapping.team4.spring.t411team.model.entity.Initiating;
import com.campingmapping.team4.spring.t424camp.model.entity.Order;
import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.entity.PostComment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userprofiles")
@Component
public class UserProfiles implements UserDetails {

  @Id
  private UUID uid;

  @Column(nullable = false, unique = true, length = 50)
  private String email;

  // private String accountId;

  @JsonIgnore
  private String password;

  @Embedded
  UserName username;

  @Embedded
  UserPrivacy userprivacy;

  @Embedded
  UserDetail userddetail;

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @ManyToMany
  @Builder.Default
  @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
      @JoinColumn(name = "rid") })
  private Set<Role> roles = new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
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
// PO文
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<Post> post;
// 留言
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<PostComment> postcomments;
// 職缺
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<JobBean> job;
// 履歷
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<ResumeBean> resume;

  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<Initiating> initiatings;
// 登入歷史
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Collection<LoginHistory> loginhistories;
// Camp訂單
  @JsonIgnore
  @JsonIgnoreProperties("userprofiles")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofiles")
  private Set<Order> CampOrder;

}
