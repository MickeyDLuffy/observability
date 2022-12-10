package com.github.mickeydluffy.observability.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndexService {

    public void log() {
        log.info("Logging inside the index service");
    }
}
