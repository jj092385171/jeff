package com.campingmapping.team4.spring.t411team.model.Dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campingmapping.team4.spring.t411team.model.entity.Initiating;

public interface InitiatingRepository extends JpaRepository<Initiating, Integer> {
	
	public List<Initiating> findByStartdateGreaterThanEqualAndEnddateLessThanEqual(Date startdate, Date enddate);
	
	public List<Initiating> findByCamparea(String camparea);
	
	@Query(value = "select * from where uid = :uid",nativeQuery = true)
	public List<Initiating> findByUid(@Param("uid") String uid);
}
