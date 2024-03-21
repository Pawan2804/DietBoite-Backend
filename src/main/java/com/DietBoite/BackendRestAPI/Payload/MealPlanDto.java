package com.DietBoite.BackendRestAPI.Payload;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class MealPlanDto {
    @JsonProperty("customerName")
    private String CustomerName;
    @JsonProperty("day")
    private String day;
    @JsonProperty("week")
    private String week;
    @JsonProperty("mealType")
    private String MealType;
    @JsonProperty("ingredients")
    private String ingredients;
}
