package com.agendaai.company.dtos;

import java.util.ArrayList;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CompanyRecordDto(
                        @NotBlank String companyName, 
                        @NotBlank String companyCep,
                        @NotBlank String companyPassword,
                        @NotBlank String companyCnpj,
                        @NotBlank @Email String companyEmail,
                        @NotBlank String companyTelNumber,
                        ArrayList<String> companySocialLinks) {

}