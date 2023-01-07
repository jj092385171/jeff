package com.campingmapping.team4.spring.t4_01Member.model.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_01Member.model.entity.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

    Optional<License> findByAccount(String account);
}
