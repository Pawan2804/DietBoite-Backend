package com.DietBoite.BackendRestAPI.Service.impl;

import com.DietBoite.BackendRestAPI.Exception.ResourceNotFoundException;
import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Repository.CustomerRepo;
import com.DietBoite.BackendRestAPI.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerModel createCustomer(CustomerModel customerModel) {
        return customerRepo.save(customerModel);
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public CustomerModel getCustomersById(Long id) {
        return customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
    }

    @Override
    public CustomerModel updateCustomerById(Long id, CustomerModel customerModel) {
        CustomerModel customer = customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
        customer.setUserName(customerModel.getUserName());
        customer.setEmail(customerModel.getEmail());
        customer.setPhoneNumber(customerModel.getPhoneNumber());
        CustomerModel updatedPost = customerRepo.save(customer);
        return updatedPost;
    }

}
