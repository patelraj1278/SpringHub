package com.example.springhub.remote.product.webflux.service;

import com.example.springhub.remote.product.webflux.model.Parent;
import reactor.core.publisher.Flux;

public interface IEmployeeService{
    Flux<Parent> findAll();

}