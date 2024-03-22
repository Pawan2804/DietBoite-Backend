package com.DietBoite.BackendRestAPI.Service.impl;

import com.DietBoite.BackendRestAPI.Exception.ResourceNotFoundException;
import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Repository.CustomerRepo;
import com.DietBoite.BackendRestAPI.Repository.MealPlanRepo;
import com.DietBoite.BackendRestAPI.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;
    private MealPlanRepo mealPlanRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, MealPlanRepo mealPlanRepo) {
        this.customerRepo = customerRepo;
        this.mealPlanRepo = mealPlanRepo;
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

//    @Override
//    public void deleteCustomer(Long id) {
//        CustomerModel customer = customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
//        List<MealPlanModel> mealPlan = mealPlanRepo.findAllById(Collections.singleton(customer.getUserId()));
//        mealPlanRepo.deleteAll(mealPlan);
//        customerRepo.delete(customer);
//
//    }
public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
}

}
