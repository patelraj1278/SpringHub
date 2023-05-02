package com.example.springhub.remote.product.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface GetProducts {
    @RequestMapping(method = RequestMethod.GET, value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    String getProducts();
}

