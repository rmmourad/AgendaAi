package com.agendaai.products.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendaai.products.models.ProductModel;
import com.agendaai.products.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductModel save(ProductModel pModel) {
        return productRepository.save(pModel);
    }

    public ProductModel getProductByid(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<ProductModel> getAllProducts(UUID productId) {
        return productRepository.findAll();
    }

    @Transactional
    public ProductModel updateProduct(UUID productId, ProductModel pModel) {
        ProductModel existingProduct = getProductByid(productId);

        if (existingProduct != null) {
            existingProduct.setProductPrice(pModel.getProductPrice());
            existingProduct.setProductDescr(pModel.getProductDescr());

            return productRepository.save(existingProduct);
        }

        return null;
    }

    public void deleteProductById(UUID productId) {
        productRepository.deleteById(productId);
    }

}
