package com.campingmapping.team4.spring.t424camp.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t424camp.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
