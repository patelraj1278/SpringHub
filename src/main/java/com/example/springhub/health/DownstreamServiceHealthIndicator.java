package com.example.springhub.health;

import com.example.springhub.remote.product.webflux.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component("productHealth")
public class DownstreamServiceHealthIndicator implements ReactiveHealthIndicator {

    @Autowired
    WebClient webClient;

    @Override
    public Mono<Health> getHealth(boolean includeDetails) {
        return ReactiveHealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Mono<Health> health() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(Parent.class)
                .timeout(Duration.ofMillis(10_000))
                .map(x-> new Health.Builder().up().build())
                .onErrorResume(ex -> Mono.just(new Health.Builder().down().build()));
    }
}
