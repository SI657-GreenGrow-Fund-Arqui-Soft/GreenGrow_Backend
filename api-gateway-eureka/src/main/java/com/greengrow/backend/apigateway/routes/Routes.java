package com.greengrow.backend.apigateway.routes;

import com.greengrow.backend.apigateway.handlers.LoadBalancerHandler;
import org.apache.catalina.Server;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    private final LoadBalancerHandler loadBalancerHandler;

    public Routes(LoadBalancerHandler loadBalancerHandler) {
        this.loadBalancerHandler = loadBalancerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> articlesServiceRoute() {
        String routeId = "articles-service";
        String fallbackUrl = "/articlesFallback";
        return GatewayRouterFunctions.route(routeId)
                .route(RequestPredicates.path("/api/green-grow/v1/articles"),
                        request -> loadBalancerHandler.handler(routeId, fallbackUrl, request))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> coursesServiceRoute() {
        return loadBalancedGreenGrowRoute(
                "courses-service",
                "courses",
                "/coursesFallback"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> postsServiceRoute() {
        return loadBalancedGreenGrowRoute(
                "posts-service",
                "posts",
                "/postsFallback"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> profilesServiceRoute() {
        return loadBalancedGreenGrowRoute(
                "profiles-service",
                "profile",
                "/profilesFallback"
        );
    }

    @Bean
    public RouterFunction<ServerResponse> trendsServiceRoute() {
        return loadBalancedGreenGrowRoute(
                "trends-service",
                "trends",
                "/trendsFallback"
        );
    }

    private RouterFunction<ServerResponse> generalGreenGrowRoute(
            String routeId, String path, String url
    ) {
        String basePath = "/api/green-grow/v1/";
        return GatewayRouterFunctions.route(routeId)
                .route(RequestPredicates.path(basePath + path)
                        , HandlerFunctions.http(url))
                .build();
    }

    private RouterFunction<ServerResponse> loadBalancedGreenGrowRoute(
            String routeId,
            String path,
            String fallbackUrl
    ) {
        String basePath = "/api/green-grow/v1/";
        return GatewayRouterFunctions.route(routeId)
                .route(RequestPredicates.path(basePath + path),
                        request -> loadBalancerHandler.handler(routeId, fallbackUrl, request))
                .build();
    }
}
