package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "passwordhistory")
public class PasswordHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phid")
    private Integer phid;

    @Column(name = "account")
    private String account;

    @Column(name = "oldpassword")
    private String oldpassword;

    @Column(name = "setpswdate")
    private Date setpswdate;

}