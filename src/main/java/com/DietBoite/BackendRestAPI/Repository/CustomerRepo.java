package com.DietBoite.BackendRestAPI.Repository;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerModel,Long> {
    CustomerModel findByuserName(String name);

}
