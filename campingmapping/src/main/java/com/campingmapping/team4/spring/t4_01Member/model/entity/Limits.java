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
    // post
    // 發文
    @Column(name = "post")
    private String post;
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
    // teamleader
    // 揪團主
    @Column(name = "teamleader")
    private String teamleader;
    // teammember
    // 參加者
    @Column(name = "teammember")
    private String teammember;
    // campingowner
    // 營主
    @Column(name = "campingowner")
    private String campingowner;
    // camporder
    // 營地預定
    @Column(name = "camporder")
    private String camporder;
    // admin
    @Column(name = "admin")
    private String admin;
    // camper
    @Column(name = "camper")
    private String camper;
    // show
    @Column(name = "show")
    private String show;

    @JsonIgnoreProperties("limits")
    @OneToOne
    @JoinColumn(name = "uid")
    private Member member;

}
