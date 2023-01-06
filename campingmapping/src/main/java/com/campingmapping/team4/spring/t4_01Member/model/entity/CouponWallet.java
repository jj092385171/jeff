package com.campingmapping.team4.spring.t4_01Member.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//票券夾
// couponwallet
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couponwallet")
public class CouponWallet {

    // cwid
    // 票券夾ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cwid")
    private Integer cwid;
    // uid
    // 擁有者ID
    @Column(name = "uid")
    private Integer uid;
    // couponid
    // 票券ID
    @Column(name = "couponid")
    private Integer couponid;
    // state
    // 狀態(1.未使用 2.已使用 3.已過期 4.暫停)
    @Column(name = "state")
    private Integer state;
    // show
    @Column(name = "show")
    private String show;

    @JsonIgnoreProperties("couponwallet")
    @ManyToOne
    @JoinColumn(name = "coupon_couponid")
    private Coupon coupon;

    @JsonIgnoreProperties("couponwallet")
    @ManyToOne
    @JoinColumn(name = "member_uid")
    private Member member;

}
