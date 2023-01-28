package com.campingmapping.team4.spring.t401member.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    // 暱稱
    private String nickname;

    // 經驗
    @Column(columnDefinition = "default 0 notnull")
    private Long exp;

    // 等級
    @Column(columnDefinition = "default 1")
    private Integer leavel;

    // 點數
    @Column(columnDefinition = "default 0")
    private Integer point;

    // 性別
    private Integer gender;

    // 註冊日期
    @Column(columnDefinition = "default getDate()")
    private Date registerdata;

    // 訂閱
    @Column(columnDefinition = "default 'N'")
    private String subscribed;

    // 大頭像
    private String shot;

    // 自我介紹
    @Lob
    @Column(columnDefinition = "default '這個用戶什麼都沒留下~~'")
    private String about;
}