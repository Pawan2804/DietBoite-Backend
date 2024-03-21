package com.DietBoite.BackendRestAPI.Controller;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Payload.MealPlanDto;
import com.DietBoite.BackendRestAPI.Service.MealPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
