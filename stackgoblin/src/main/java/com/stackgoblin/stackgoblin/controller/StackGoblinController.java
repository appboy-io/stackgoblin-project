package com.stackgoblin.stackgoblin.controller;

import com.stackgoblin.stackgoblin.model.LanguageTag;
import com.stackgoblin.stackgoblin.service.StackGoblinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RestController
public class StackGoblinController {

    private Logger logger = LoggerFactory.getLogger(StackGoblinController.class);

    private final StackGoblinService stackGoblinService;

    StackGoblinController(StackGoblinService stackGoblinService) {
        this.stackGoblinService = stackGoblinService;
    }

    @GetMapping
    public String serviceCheck() {
        logger.info("Service check at : {}", LocalDateTime.now());
        return "Service is up";
    }

    @GetMapping("/add")
    public LanguageTag makeNewTag() {
        return stackGoblinService.addRandomLanguage();
    }

    @GetMapping("/all")
    public Flux<LanguageTag> getAll() {
        return stackGoblinService.returnAll();
    }
}
