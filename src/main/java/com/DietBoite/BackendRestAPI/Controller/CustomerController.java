package com.DietBoite.BackendRestAPI.Controller;

import com.DietBoite.BackendRestAPI.Model.CustomerModel;
import com.DietBoite.BackendRestAPI.Service.CustomerService;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel){
        return new ResponseEntity<>(customerService.createCustomer(customerModel), HttpStatus.OK);
    }
    @GetMapping("/get")
    public List<CustomerModel> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/get/{id}")
    public CustomerModel getAllCustomers(@PathVariable(name = "id") Long id){
        return customerService.getCustomersById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable(name = "id") Long id, @RequestBody CustomerModel customerModel){
        CustomerModel response =customerService.updateCustomerById(id,customerModel);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }



}
