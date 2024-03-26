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
    public MealPlanModel partialUpdate(MealPlanDto mealPlanDto, String customerName, String week,String day, String mealType);
    public Map<String, Integer > getOverallAnalytics();
    public Map<String, Integer > getWeeklyAnalytics(String week);
    public Map<String, Integer > getDailyAnalytics(String day);
    public List<String> getIngredientsList();
    public MealPlanModel getByCustomerPlan(String customerName, String week,String day, String mealType);
}
