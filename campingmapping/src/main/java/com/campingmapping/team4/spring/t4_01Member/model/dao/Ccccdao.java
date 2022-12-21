package com.campingmapping.team4.spring.t4_01Member.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Cccc;

public interface Ccccdao extends JpaRepository<Cccc, Long>{

	public List<Cccc>  findAll();
}
