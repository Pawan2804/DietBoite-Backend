package com.DietBoite.BackendRestAPI.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;

@Entity
@Data
@ToString
@IdClass(MealPlanPK.class)
@Table(name = "MealPlan")
public class MealPlanModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerModel customer;
    @Id
    private String day;
    @Id
    private String week;
    @Id
    private String MealType;
    private String ingredients;

}
