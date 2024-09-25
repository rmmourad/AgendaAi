package com.agendaai.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaai.company.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID>{

}
