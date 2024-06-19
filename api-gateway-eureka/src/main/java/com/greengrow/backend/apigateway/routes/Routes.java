package com.greengrow.backend.apigateway.routes;

import com.greengrow.backend.apigateway.handlers.CircuitBreakerHandler;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    private final CircuitBreakerHandler circuitBreakerHandler;

    public Routes(CircuitBreakerHandler circuitBreakerHandler) {
        this.circuitBreakerHandler = circuitBreakerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> articlesServiceRoute() {
        String routeId = "articles-service";
        return GatewayRouterFunctions.route(routeId)
                .route(RequestPredicates.path("/api/green-grow/v1/articles"),
                        request -> circuitBreakerHandler.handler(routeId, request))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> coursesServiceRoute() {
        return generalGreenGrowRoute(
                "courses-service",
                "course",
                "http://localhost:8081"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> postsServiceRoute() {
        return generalGreenGrowRoute(
                "posts-service",
                "posts",
                "http://localhost:8082"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> profilesServiceRoute() {
        return generalGreenGrowRoute(
                "profiles-service",
                "profile",
                "http://localhost:8083"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> trendsServiceRoute() {
        return generalGreenGrowRoute(
                "trends-service",
                "trends",
                "http://localhost:8084"
        );
    }

    static private RouterFunction<ServerResponse> generalGreenGrowRoute(
            String routeId, String path, String url
    ) {
        String basePath = "/api/green-grow/v1/";
        return GatewayRouterFunctions.route(routeId)
                .route(RequestPredicates.path(basePath + path)
                        , HandlerFunctions.http(url))
                .build();
    }
}
