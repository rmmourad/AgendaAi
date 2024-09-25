package com.agendaai.products.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record ProductRecordDto(
                    UUID companyId,
                    double productPrice,
                    @NotBlank String productDescr,
                    @NotBlank String productPic) {

}
