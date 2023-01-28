// package com.campingmapping.team4.spring.t401member.model.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Builder
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name = "userroles")
// public class UserRoles {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer urid;

//     @ManyToOne
// 	// @JsonIgnore
// 	@JoinColumn(name = "uid")
// 	private UserProfiles userprofiles;

//     @ManyToOne
// 	// @JsonIgnore
// 	@JoinColumn(name = "rid")
// 	private Role role;

// }