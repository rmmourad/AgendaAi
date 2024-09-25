package com.agendaai.customer.controllers;

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

import com.agendaai.customer.dtos.CustomerRecordDto;
import com.agendaai.customer.models.CustomerModel;
import com.agendaai.customer.services.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerModel> saveCustomer(@RequestBody @Valid CustomerRecordDto customerRecordDto) {
        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customerRecordDto, customerModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable UUID customerId) {
        CustomerModel customerModel = customerService.getCustomerById(customerId);
        if(customerModel != null)
            return ResponseEntity.ok(customerModel);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<CustomerModel> updateCustomerById(@PathVariable UUID customerId, @RequestBody CustomerModel nCustomer) {
        CustomerModel customerModel = customerService.updateCustomer(customerId, nCustomer);
        return ResponseEntity.ok(customerModel);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<CustomerModel> deleteCustomerById(@PathVariable UUID customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
