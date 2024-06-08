package com.agendaai.company.controllers;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agendaai.company.dtos.CompanyRecordDto;
import com.agendaai.company.models.CompanyModel;
import com.agendaai.company.services.CompanyService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CompanyController {
    final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies")
    public ResponseEntity<CompanyModel> saveCompany(@RequestBody @Valid CompanyRecordDto companyRecordDto) {
        CompanyModel companyModel = new CompanyModel();
        BeanUtils.copyProperties(companyRecordDto, companyModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(companyModel));
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<CompanyModel> getCompanyById(@PathVariable UUID companyId) {
        CompanyModel companyModel = companyService.getCompanyById(companyId);
        if (companyModel != null)
            return ResponseEntity.ok(companyModel);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PutMapping("/companies/{companyId}")
    public ResponseEntity<CompanyModel> updateCompanyById(@PathVariable UUID companyId, @RequestBody CompanyModel nCompany) {
        CompanyModel companyModel = companyService.updateCompany(companyId, nCompany);
        return ResponseEntity.ok(companyModel);
    }



    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity<CompanyModel> deleteCompanyById(@PathVariable UUID companyId) {
        companyService.deleteCompanyById(companyId);
        return ResponseEntity.noContent().build();
    }

}
