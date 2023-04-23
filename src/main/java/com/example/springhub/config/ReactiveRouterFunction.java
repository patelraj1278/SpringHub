/*
package com.example.springhub.config;

import com.example.springhub.model.reactivemodels.Reservation;
import com.example.springhub.repository.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ReactiveRouterFunction {

    @Bean
    RouterFunction<ServerResponse> routes(ReservationRepository rr){
        return route().GET("/reservation_reactive", request -> ok()
                .body(rr.findAll(), Reservation.class))
                .build();
    }
}
*/
