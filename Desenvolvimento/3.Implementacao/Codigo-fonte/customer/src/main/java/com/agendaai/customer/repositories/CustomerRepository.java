package com.agendaai.customer.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaai.customer.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID>{

}
