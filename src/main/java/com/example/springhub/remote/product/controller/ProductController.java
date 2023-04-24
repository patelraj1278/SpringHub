/*
package com.example.springhub.remote.product.controller;

import com.example.springhub.remote.product.client.GetProducts;
import com.example.springhub.remote.product.model.Parent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    GetProducts getProducts;

    @GetMapping(value = "users",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll() throws JsonProcessingException {

        String jsonString = getProducts.getProducts();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Parent langs = objectMapper.readValue(jsonString,Parent.class);
        System.out.println(langs.getProducts().get(0).getTitle());

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}
*/
