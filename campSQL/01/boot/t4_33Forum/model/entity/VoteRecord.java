// package com.campingmapping.team4.spring.t4_33Forum.model.entity;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @Entity
// @Table(name = "voteRecord")
// public class VoteRecord {
// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
// @JoinTable()
// private Integer optionId;
// private Integer userId;
// }
