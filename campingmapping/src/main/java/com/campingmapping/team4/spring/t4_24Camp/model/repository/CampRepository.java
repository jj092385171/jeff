package com.campingmapping.team4.spring.t4_24Camp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_24Camp.model.entity.Camp;

public interface CampRepository extends JpaRepository<Camp, Integer> {

}
