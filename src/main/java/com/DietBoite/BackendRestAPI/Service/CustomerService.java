package com.DietBoite.BackendRestAPI.Service;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    public CustomerModel createCustomer(CustomerModel customerModel);
    public List<CustomerModel> getAllCustomers();
    public CustomerModel getCustomersById(Long id);
    public CustomerModel updateCustomerById(Long id, CustomerModel customerModel);
    public void deleteCustomer(Long id);
}
