package com.example.springhub.remote.product.webflux.controller;

import com.example.springhub.remote.product.webflux.model.Parent;
import com.example.springhub.remote.product.webflux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController("/getEmployee")
public class ProductFluxController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Parent> findAll() {
        return employeeService.findAll();
    }
}