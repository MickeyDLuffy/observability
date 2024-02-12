package com.github.mickeydluffy.observability.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.Hashtable;
import java.util.UUID;

@Component
@Slf4j
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestId = UUID.randomUUID().toString();
            MDC.put("requestId", requestId);
            log.info("{} request to {} ",request.getMethod(), request.getRequestURI());

            ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
                    response
            );
            filterChain.doFilter(request,responseWrapper);
            responseWrapper.setHeader("x-request-id", requestId);
        } finally {
            MDC.clear();
        }

    }
}
