package com.example.springhub.reactive.router;

import com.example.springhub.reactive.handler.TutorialHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    TutorialHandler tutorialHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/route/tutorials",tutorialHandler::getTutorialList)
                .GET("/route/tutorials/published",tutorialHandler::findByPublished)
                .GET("/route/tutorials/{id}",tutorialHandler::getTutorialListById)
                .POST("/route/tutorials/saveTutorials",tutorialHandler::saveTutorials)
                .build();
    }
}