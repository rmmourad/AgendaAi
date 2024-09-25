package com.agendaai.customer.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_CUSTOMER")
public class CustomerModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customerID;
    private String customerName;
    private String customerEmail;
    private String customerCpf;
    // private String customerPassword;
    private String customerTelNumber;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }

    public void setCustomerCpf(String customerCPF) {
        this.customerCpf = customerCPF;
    }
    
    // public String getCustomerPassword() {
    //     return customerPassword;
    // }
    
    // public void setCustomerPassword(String customerPassword) {
    //     this.customerPassword = customerPassword;
    // }
    
    public String getCustomerTelNumber() {
        return customerTelNumber;
    }
    
    public void setCustomerTelNumber(String customerTelNumber) {
        this.customerTelNumber = customerTelNumber;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    
}
