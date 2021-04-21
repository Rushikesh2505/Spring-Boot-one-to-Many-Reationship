package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
