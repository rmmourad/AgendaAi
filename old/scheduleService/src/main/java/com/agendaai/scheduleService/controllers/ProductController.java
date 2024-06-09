// package com.agendaai.scheduleService.controllers;

// import java.util.UUID;

// import org.springframework.beans.BeanUtils;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.agendaai.scheduleService.dtos.ProductRecordDto;
// import com.agendaai.scheduleService.models.ProductModel;
// import com.agendaai.scheduleService.services.ProductService;

// import jakarta.validation.Valid;

// @RestController
// public class ProductController {
//     final ProductService pService;

//     public ProductController(ProductService pService) {
//         this.pService = pService;
//     }

//     @PostMapping("products")
//     public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto pDto) {
//         ProductModel pModel = new ProductModel();
//         BeanUtils.copyProperties(pDto, pModel);

//         ResponseEntity.status(HttpStatus.CREATED).body(pService.save(pModel));
        
//     }
// }
