package com.agendaai.products.dtos;

import java.util.ArrayList;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record ProductRecordDto(
                    @NotBlank UUID companyId,
                    @NotBlank double productPrice,
                    @NotBlank String productDescr,
                    @NotBlank ArrayList<String> productPics) {

}
