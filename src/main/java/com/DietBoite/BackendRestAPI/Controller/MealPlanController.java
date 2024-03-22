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
    @PatchMapping("/update/{id}")
    public ResponseEntity<MealPlanModel> partialUpdate(@PathVariable Long id,@RequestBody MealPlanDto mealPlanDto){
        MealPlanModel updatedMeal = mealPlanService.partialUpdate(id,mealPlanDto);
        return ResponseEntity.ok(updatedMeal);
    }
    @GetMapping("/getAnalytics")
    public Map<String, Integer> getOverallAnalytics(){
        return mealPlanService.getOverallAnalytics();
    }
    @GetMapping("/getIngredients")
    public List<String> getIngredientList(){
        return mealPlanService.getIngredientsList();
    }


}
