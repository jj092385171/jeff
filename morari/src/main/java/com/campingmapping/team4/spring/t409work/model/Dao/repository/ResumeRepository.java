package com.campingmapping.team4.spring.t409work.model.Dao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;

public interface ResumeRepository extends JpaRepository<ResumeBean, Integer> {

//	@Query(value = "select* from resume where uid =?1",nativeQuery = true)
//	public ResumeBean findByUid(UUID uid);

}
