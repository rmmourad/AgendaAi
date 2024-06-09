package com.example.scheduleService.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scheduleService.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

}
