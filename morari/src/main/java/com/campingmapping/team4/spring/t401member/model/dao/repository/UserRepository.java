package com.campingmapping.team4.spring.t401member.model.dao.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

public interface UserRepository extends JpaRepository<UserProfiles, Integer> {

  Optional<UserProfiles> findByAccount(String account);

}
