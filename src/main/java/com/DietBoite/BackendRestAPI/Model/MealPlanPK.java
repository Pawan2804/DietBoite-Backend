package com.DietBoite.BackendRestAPI.Model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
@Data
public class MealPlanPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerModel customer;
    private String day;
    private String week;
    private String MealType;
}
