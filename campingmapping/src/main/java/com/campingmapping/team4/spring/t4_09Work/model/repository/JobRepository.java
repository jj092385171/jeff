package com.campingmapping.team4.spring.t4_09Work.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_09Work.model.entity.JobBean;

public interface JobRepository extends JpaRepository<JobBean, Integer> {

}
