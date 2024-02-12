package com.github.mickeydluffy.observability.controller;

import com.github.mickeydluffy.observability.dto.ApiResponse;
import com.github.mickeydluffy.observability.service.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class IndexController {
    public static final String MICKEY = "Mickey";
    private final IndexService indexService;
    @GetMapping("/index")
    @Cacheable(value = "index")
    public @ResponseBody ResponseEntity<?> getIndex() {
        log.info("Entered into the index controller. {}", indexService.getIndex());
        log.warn("Consider avoiding useless comments");
        log.warn("testing the third log");
        indexService.log();
       var d =  ApiResponse.builder().response(MICKEY).build();
        return ResponseEntity.ok(d);
    }

    @GetMapping("/next")
    public Map<String, String> getNext() {
        log.info("Next is logging");
        return Map.of("Data", "next");
    }
}
