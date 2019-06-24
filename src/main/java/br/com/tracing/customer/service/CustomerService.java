package br.com.tracing.customer.service;

import br.com.tracing.customer.dto.CustomerDTO;
import br.com.tracing.customer.entity.Customer;
import br.com.tracing.customer.exception.ResourceNotFoundException;
import br.com.tracing.customer.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){

        Customer customer = customerDTO.toEntity();
        customer.setId(UUID.randomUUID().toString());

        return this.customerRepository.save(customer).toDto();
    }

    public CustomerDTO findCustomerById(String id) {
        return this.customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer not found")).toDto();
    }

}
