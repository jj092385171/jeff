package com.campingmapping.team4.spring.t4_01Member.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// limits
//權限
@Data
@NoArgsConstructor
@Entity
@Table(name = "limits")
public class Limits {
    // uid
    @Id
    @Column(name = "uid")
    private Integer uid;
    // nomore
    // 一般
    @Column(name = "nomore")
    private String nomore;
    // buy
    // 買家
    @Column(name = "buy")
    private String buy;
    // sell
    // 賣家
    @Column(name = "sell")
    private String sell;
    // publisher
    // 發文
    @Column(name = "publisher")
    private String publisher;
    // message
    // 留言
    @Column(name = "message")
    private String message;
    // enterprise
    // 雇主
    @Column(name = "enterprise")
    private String enterprise;
    // applier
    // 應徵者
    @Column(name = "applier")
    private String applier;
    // mainhoster
    // 揪團主
    @Column(name = "mainhoster")
    private String mainhoster;
    // attender
    // 參加者
    @Column(name = "attender")
    private String attender;
    // campingowner
    // 營主
    @Column(name = "campingowner")
    private String campingowner;
    // customer
    // 營地預定
    @Column(name = "customer")
    private String customer;
    // admin
    @Column(name = "admin")
    private String admin;
    // member
    @Column(name = "members")
    private String members;
    // show
    @Column(name = "show")
    private String show;

    @JsonIgnoreProperties("limits")
    @OneToOne
    @JoinColumn(name = "uid")
    private Member member;

}
