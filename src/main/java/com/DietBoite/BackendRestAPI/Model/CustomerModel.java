package com.DietBoite.BackendRestAPI.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String Email;
    private String PhoneNumber;
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<MealPlanModel> mealPlans;

}
