package com.DietBoite.BackendRestAPI.Service;

import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import org.springframework.stereotype.Service;

@Service
public interface MealPlanService {
    public MealPlanModel createMealPlan(MealPlanDto mealPlanDto);
    public MealPlanModel partialUpdate(Long id,MealPlanDto mealPlanDto);
}
