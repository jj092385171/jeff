package com.campingmapping.team4.spring.t401member.model.dao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, UUID> {

}
