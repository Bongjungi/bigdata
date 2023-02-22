package com.wed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wed.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
