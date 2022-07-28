package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()

                .route(r -> r.path("/add/**")
                        .uri("http://localhost:8000/"))

                .route(r -> r.path("/test/**")
                        .filters(f -> f.rewritePath("test", "add")
                                .removeRequestParameter("b")
                                .addRequestParameter("b", "-2"))
                        .uri("http://localhost:8001/"))
                .build();
    }
}
