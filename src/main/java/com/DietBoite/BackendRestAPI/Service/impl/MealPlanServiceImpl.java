package com.DietBoite.BackendRestAPI.Service.impl;

import com.DietBoite.BackendRestAPI.Exception.ResourceNotFoundException;
import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import com.DietBoite.BackendRestAPI.Repository.CustomerRepo;
import com.DietBoite.BackendRestAPI.Repository.MealPlanRepo;
import com.DietBoite.BackendRestAPI.Service.MealPlanService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public MealPlanModel partialUpdate(Long id, MealPlanDto mealPlanDto) {
        MealPlanModel meal = mealPlanRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Meal","id",id));
        if (mealPlanDto.getMealType()!= null) {
            meal.setMealType(mealPlanDto.getMealType());
        }
        if (mealPlanDto.getWeek() != null) {
            meal.setWeek(mealPlanDto.getWeek());
        }
        if (mealPlanDto.getDay() != null) {
            meal.setDay(mealPlanDto.getDay());
        }
        if (mealPlanDto.getIngredients() != null) {
            meal.setIngredients(mealPlanDto.getIngredients());
        }
        return mealPlanRepo.save(meal);
    }

    @Override
    public Map<String, Integer> getOverallAnalytics() {
       List<String> meals = mealPlanRepo.findIngredients();
        Map<String, Integer> totalQuantityMap = calculateTotalQuantity(meals);
        return totalQuantityMap;
    }


    public List<String> getIngredientsList() {
        List<String> meals = mealPlanRepo.findIngredients();
        return meals;
    }
    public Map<String, Integer> calculateTotalQuantity(List<String> itemList) {
        Map<String, Integer> totalQuantityMap = new HashMap<>();

        for (String item : itemList) {
            String[] components = item.split(", ");
            for (String component : components) {
                String[] parts = component.split("-");
                String itemName = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].replaceAll("[^0-9]", "").trim());

                totalQuantityMap.put(itemName, totalQuantityMap.getOrDefault(itemName, 0) + quantity);
            }
        }

        return totalQuantityMap;
    }

}
