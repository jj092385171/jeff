package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// loginhistory
//登入歷史
@Data
@NoArgsConstructor
@Entity
@Table(name = "loginhistory")
public class LoginHistory {

    // lhid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lhid")
    private Integer lhid;
    // uid
    @Column(name = "uid")
    private Integer uid;
    // ip
    // IP位置
    @Column(name = "ip")
    private String ip;
    // logindate
    // 登入時間
    @Column(name = "logindate")
    private Date logindate;
    // show
    @Column(name = "show")
    private String show;

    @JsonIgnoreProperties("loginhistory")
    @ManyToOne
    @JoinColumn(name = "member_uid")
    private Member member;

}
