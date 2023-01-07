package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// license
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "license")
public class License implements UserDetails {
    // uid
    @Id
    @Column(name = "uid")
    private Integer uid;
    // facebookid
    @Column(name = "facebookid")
    private String facebookid;
    // googleid
    @Column(name = "googleid")
    private String googleid;
    // lineid
    @Column(name = "lineid")
    private String lineid;
    // password
    @Column(name = "password")
    private String password;
    // show
    @Column(name = "show")
    private String show;

    @JsonIgnoreProperties("license")
    @OneToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private Member member;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return member.getAccount();
    }

    @Override
    public String getPassword() {
        return password;
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

}
