package com.campingmapping.team4.spring.t409work.model.Dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;

public interface JobRepository extends JpaRepository<JobBean, Integer> {

	@Query(value = "from JobBean where job like concat('%',?1,'%')")
	public List<JobBean> findByJobisLike(String job);
	
	
//	@Query(value = "select * from JobBean where uid = ?1" ,nativeQuery = true)
//	public List<JobBean> findByUid(Integer uid);
//	
}
