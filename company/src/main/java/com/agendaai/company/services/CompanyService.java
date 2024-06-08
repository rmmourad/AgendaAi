package com.agendaai.company.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendaai.company.models.CompanyModel;
import com.agendaai.company.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    
    @Transactional
    public CompanyModel save(CompanyModel companyModel) {
        return companyRepository.save(companyModel);
    }

    public CompanyModel getCompanyById(UUID companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Transactional
    public CompanyModel updateCompany(UUID companyId, CompanyModel nCompany) {
        CompanyModel existingCompany = companyRepository.findById(companyId).orElse(null);
        if (existingCompany != null) {
            existingCompany.setCompanyName(nCompany.getCompanyName());
            existingCompany.setCompanyCep(nCompany.getCompanyCep());
            existingCompany.setCompanyCnpj(nCompany.getCompanyCnpj());
            existingCompany.setCompanyEmail(nCompany.getCompanyEmail());
            existingCompany.setCompanyTelNumber(nCompany.getCompanyTelNumber());

            return companyRepository.save(existingCompany);
        }

        // TODO: Trocar por trycatch e se der errado soltar uma exception
        // Retornar null em caso de erro pode dar erro no banco de dados
        return null;
    }
    
    public void deleteCompanyById(UUID companyId) {
        companyRepository.deleteById(companyId);
    }
}
