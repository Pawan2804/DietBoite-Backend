package com.DietBoite.BackendRestAPI.Repository;

import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlanRepo extends JpaRepository<MealPlanModel,Long> {
}
