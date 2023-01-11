package com.campingmapping.team4.spring.t401member.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class License {
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

}
