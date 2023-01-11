package com.campingmapping.team4.spring.t409work.model.Dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;

public interface JobRepository extends JpaRepository<JobBean, Integer> {

}
