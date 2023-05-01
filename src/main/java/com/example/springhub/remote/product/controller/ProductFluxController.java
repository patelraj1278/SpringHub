/*
package com.example.springhub.remote.product.controller;

import com.example.springhub.remote.product.model.Parent;
import com.example.springhub.remote.product.model.Products;
import com.example.springhub.remote.product.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/getEmployee")
public class ProductFluxController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Parent> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Products> findById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }
}
*/
