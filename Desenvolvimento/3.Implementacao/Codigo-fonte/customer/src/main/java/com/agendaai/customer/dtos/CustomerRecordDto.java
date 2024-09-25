package com.agendaai.customer.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRecordDto(
                        @NotBlank String customerName,
                        @NotBlank @Email String customerEmail,
                        @NotBlank String customerCpf,
                        // @NotBlank String customerPassword,
                        @NotBlank String customerTelNumber) {

}
