package com.agendaai.customer.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendaai.customer.models.CustomerModel;
import com.agendaai.customer.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    
    @Transactional
    public CustomerModel save(CustomerModel customerModel) {
        return customerRepository.save(customerModel);
    }

    public CustomerModel getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Transactional
    public CustomerModel updateCustomer(UUID customerId, CustomerModel nCustomer) {
        CustomerModel existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setCustomerName(nCustomer.getCustomerName());
            existingCustomer.setCustomerEmail(nCustomer.getCustomerEmail());
            existingCustomer.setCustomerCpf(nCustomer.getCustomerCpf());
            existingCustomer.setCustomerPassword(nCustomer.getCustomerPassword());
            existingCustomer.setCustomerTelNumber(nCustomer.getCustomerTelNumber());
            return customerRepository.save(existingCustomer);
        }

        // TODO: Trocar por trycatch e se der errado soltar uma exception
        // Retornar null em caso de erro pode dar erro no banco de dados
        return null;
    }
    
    public void deleteCustomerById(UUID customerId) {
        customerRepository.deleteById(customerId);
    }

}
