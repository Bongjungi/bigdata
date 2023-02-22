package com.wed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wed.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
