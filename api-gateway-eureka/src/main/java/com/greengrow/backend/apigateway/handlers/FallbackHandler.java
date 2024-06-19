package com.greengrow.backend.apigateway.handlers;

import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@FunctionalInterface
public interface FallbackHandler {

    ServerResponse fallback(ServerRequest request, Exception e);

    default ServerResponse defaultFallback(ServerRequest request, Exception e) {
        try {
            return HandlerFunctions.forward("/articlesFallback").handle(request);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}