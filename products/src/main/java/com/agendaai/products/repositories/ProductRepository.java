package com.agendaai.products.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaai.products.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

}
