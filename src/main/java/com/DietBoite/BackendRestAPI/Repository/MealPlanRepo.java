package com.DietBoite.BackendRestAPI.Repository;

import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepo extends JpaRepository<MealPlanModel,Long> {
}
