package com.DietBoite.BackendRestAPI.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Data
@Table(name = "MealPlan")
public class MealPlanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealID;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerModel customer;
    private String day;
    private String week;
    private String MealType;
    private String ingredients;

}
