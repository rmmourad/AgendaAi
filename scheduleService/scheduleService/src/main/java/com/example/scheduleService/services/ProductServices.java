package com.example.scheduleService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scheduleService.repositories.ProductRepository;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    
}
