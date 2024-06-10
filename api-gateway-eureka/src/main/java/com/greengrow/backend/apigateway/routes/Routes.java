package com.greengrow.backend.apigateway.routes;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.time.Duration;
import java.util.concurrent.Callable;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> articlesServiceRoute() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .slidingWindowSize(10)
                .build();

        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("Circuit_Breaker");
        return GatewayRouterFunctions.route("articles-service")
                .route(RequestPredicates.path("/api/green-grow/v1/articles/**"),
                        request -> {
                            Callable<ServerResponse> responseCallable = circuitBreaker.decorateCallable(() -> {
                                try {
                                    return HandlerFunctions.http("lb://articles-service")
                                            .handle(request);
                                } catch (Exception e) {
                                    return ServerResponse.status(500).body(e.getMessage());
                                }
                            });
                            try {
                                return responseCallable.call();
                            } catch (Exception e) {
                                return HandlerFunctions.forward("/articlesFallback").handle(request);
                            }
                        })
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
