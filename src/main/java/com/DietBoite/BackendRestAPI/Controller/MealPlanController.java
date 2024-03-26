package com.DietBoite.BackendRestAPI.Controller;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import com.DietBoite.BackendRestAPI.Service.CustomerService;
import com.DietBoite.BackendRestAPI.Service.MealPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/mealplan")
public class MealPlanController {
    MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @PostMapping("/create")
    public ResponseEntity<MealPlanModel> createCustomer(@RequestBody MealPlanDto mealPlanDto){
        return new ResponseEntity<>(mealPlanService.createMealPlan(mealPlanDto), HttpStatus.OK);
    }
    @PatchMapping("/update/{customerName}/{weekNumber}/{dayName}/{mealType}")
    public ResponseEntity<MealPlanModel> partialUpdate(@RequestBody MealPlanDto mealPlanDto, @PathVariable String customerName,
                                                       @PathVariable String weekNumber,
                                                       @PathVariable String dayName,
                                                       @PathVariable String mealType){
        MealPlanModel updatedMeal = mealPlanService.partialUpdate(mealPlanDto, customerName, weekNumber,dayName, mealType);
        return ResponseEntity.ok(updatedMeal);
    }
    @GetMapping("/overallAnalytics")
    public Map<String, Integer> getOverallAnalytics(){
        return mealPlanService.getOverallAnalytics();
    }
    @GetMapping("/weeklyAnalytics/{week}")
    public Map<String, Integer> getWeeklyAnalytics(@PathVariable String week){
        return mealPlanService.getWeeklyAnalytics(week);
    }
    @GetMapping("/dailyAnalytics/{day}")
    public Map<String, Integer> getDailyAnalytics(@PathVariable String day){
        return mealPlanService.getDailyAnalytics(day);
    }
    @GetMapping("/getIngredients")
    public List<String> getIngredientList(){
        return mealPlanService.getIngredientsList();
    }
    @GetMapping("/getByCustomerPlan/{customerName}/{week}/{day}/{mealType}")
    public MealPlanModel getByCustomerPlan(@PathVariable String customerName,
                                    @PathVariable String week,
                                    @PathVariable String day,
                                    @PathVariable String mealType){
        return mealPlanService.getByCustomerPlan(customerName,week,day,mealType);
    }


}
