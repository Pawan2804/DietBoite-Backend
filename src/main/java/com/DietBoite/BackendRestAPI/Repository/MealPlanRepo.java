package com.DietBoite.BackendRestAPI.Repository;
import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanModel;
import com.DietBoite.BackendRestAPI.Model.MealPlanPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MealPlanRepo extends JpaRepository<MealPlanModel, MealPlanPK> {
    @Query("SELECT m FROM MealPlanModel m WHERE m.customer.customerId = :customerId " +
            "AND m.week = :week AND m.day = :day AND m.MealType = :mealType")
    MealPlanModel findByCustomerPlan(Long customerId, String week, String day, String mealType);
    @Query("Select m.ingredients from MealPlanModel m")
    List<String> findIngredients();
    @Query("Select m.ingredients from MealPlanModel m where m.week= ?1")
    List<String> findWeeklyIngredients(String week);
    @Query("Select m.ingredients from MealPlanModel m where m.day= ?1")
    List<String> findDailyIngredients(String day);

}
