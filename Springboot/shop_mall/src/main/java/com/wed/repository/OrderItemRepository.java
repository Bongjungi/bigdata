package com.wed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wed.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
