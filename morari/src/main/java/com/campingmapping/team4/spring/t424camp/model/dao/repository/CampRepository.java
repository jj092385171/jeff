package com.campingmapping.team4.spring.t424camp.model.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;

public interface CampRepository extends JpaRepository<Camp, Integer> {

	@Query(value = "select * from camp where fkcityid = :fkcityid", nativeQuery = true)
	List<Camp>findByCityId(@Param("fkcityid") int cityId);
	
}
