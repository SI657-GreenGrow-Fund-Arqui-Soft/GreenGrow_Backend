package com.greengrow.backend.apigateway.handlers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@Component
public class CircuitBreakerHandler implements FallbackHandler {
    private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;

    public CircuitBreakerHandler(DiscoveryClient discoveryClient, LoadBalancerClient loadBalancerClient) {
        this.discoveryClient = discoveryClient;
        this.loadBalancerClient = loadBalancerClient;
    }

    public ServerResponse handler(String routeId, ServerRequest request) {
        try {
            //List<ServiceInstance> instances = discoveryClient.getInstances(routeId);
            //ServiceInstance instance = instances.get(0);
            //String url = instance.getUri().toString();
            String instanceUrl = loadBalancerClient.choose(routeId).getUri().toString();
            return HandlerFunctions.http(instanceUrl).handle(request);
        } catch(Exception e) {
            return fallback(request, e);
        }
    }

    @Override
    public ServerResponse fallback(ServerRequest request, Exception e) {
        return defaultFallback(request, e);
    }
}
