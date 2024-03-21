package com.DietBoite.BackendRestAPI.Service.impl;

import com.DietBoite.BackendRestAPI.Exception.ResourceNotFoundException;
import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import com.DietBoite.BackendRestAPI.Repository.CustomerRepo;
import com.DietBoite.BackendRestAPI.Repository.MealPlanRepo;
import com.DietBoite.BackendRestAPI.Service.MealPlanService;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class MealPlanServiceImpl implements MealPlanService {
    private CustomerRepo customerRepo;
    private MealPlanRepo mealPlanRepo;
    private MealPlanModel mealPlanModel;

    public MealPlanServiceImpl(CustomerRepo customerRepo, MealPlanRepo mealPlanRepo) {
        this.customerRepo = customerRepo;
        this.mealPlanRepo = mealPlanRepo;
    }

    @Override
    public MealPlanModel createMealPlan(MealPlanDto mealPlanDto) {
        String customerName = mealPlanDto.getCustomerName();
        MealPlanModel mealPlanModel = new MealPlanModel();
        CustomerModel customer = customerRepo.findByuserName(customerName);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with name: " + customerName);
        }
        mealPlanModel.setCustomer(customer);
        mealPlanModel.setMealType(mealPlanDto.getMealType());
        mealPlanModel.setWeek(mealPlanDto.getWeek());
        mealPlanModel.setDay(mealPlanDto.getDay());
        mealPlanModel.setIngredients(mealPlanDto.getIngredients());
        MealPlanModel response = mealPlanRepo.save(mealPlanModel);
        return response;
    }
}
