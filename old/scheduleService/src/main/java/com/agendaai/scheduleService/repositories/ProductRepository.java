package com.agendaai.scheduleService.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaai.scheduleService.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

}
