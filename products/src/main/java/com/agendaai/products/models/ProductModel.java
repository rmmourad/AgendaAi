package com.agendaai.products.models;

import java.util.ArrayList;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PRODUCT")
public class ProductModel {
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;
    private UUID companyId;
    private double productPrice;
    private String productDescr;
    private ArrayList<String> productPics;
    
    public UUID getProductId() {
        return productId;
    }
    
    public void setProductId(UUID id) {
        this.productId = id;
    }

    public UUID getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(UUID id) {
        this.companyId = id;
    }
    
    public double getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getProductDescr() {
        return productDescr;
    }
    
    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ArrayList<String> getProductPics() {
        return productPics;
    }

    public void setProductPics(ArrayList<String> productPics) {
        this.productPics = productPics;
    }
    
}
