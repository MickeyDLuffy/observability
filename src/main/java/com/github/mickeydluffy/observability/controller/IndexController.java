package com.github.mickeydluffy.observability.controller;

import com.github.mickeydluffy.observability.service.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class IndexController {
    private final IndexService indexService;
    @GetMapping("/index")
    public Map<String, String> getIndex() {
        log.info("Entered into the index controller. ");
        log.warn("Consider avoiding useless comments");
        log.warn("testing the third log");
        indexService.log();
        return Map.of("Data", "testing");
    }

    @GetMapping("/next")
    public Map<String, String> getNext() {
        log.info("Next is logging");
        return Map.of("Data", "next");
    }
}
