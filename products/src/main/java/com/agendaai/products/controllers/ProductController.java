package com.agendaai.products.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agendaai.products.dtos.ProductRecordDto;
import com.agendaai.products.models.ProductModel;
import com.agendaai.products.services.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    final ProductService pService;

    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto pDto) {
        ProductModel pModel = new ProductModel();
        BeanUtils.copyProperties(pDto, pModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pService.save(pModel));
    }

    @GetMapping("/products")
    public ResponseEntity<ArrayList<ProductModel>> getAllProducts() {
        ArrayList<ProductModel> pModels = (ArrayList<ProductModel>) pService.getAllProducts();

        if(pModels != null)
            return ResponseEntity.ok(pModels);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable UUID productId) {
        ProductModel pModel = pService.getProductByid(productId);
        if(pModel != null)
            return ResponseEntity.ok(pModel);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<ProductModel> updateProductById(@PathVariable UUID pUuid, @RequestBody ProductModel pModel) {
        ProductModel newModel = pService.updateProduct(pUuid, pModel);
        
        return ResponseEntity.ok(newModel);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<ProductModel> deleteProductById(@PathVariable UUID pUuid) {
        pService.deleteProductById(pUuid);
        return ResponseEntity.noContent().build();
    }

}
