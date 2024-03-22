package com.DietBoite.BackendRestAPI.Service;

import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public interface MealPlanService {
    public MealPlanModel createMealPlan(MealPlanDto mealPlanDto);
    public MealPlanModel partialUpdate(Long id,MealPlanDto mealPlanDto);
    public Map<String, Integer > getOverallAnalytics();
    public List<String> getIngredientsList();
}
