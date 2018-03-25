package com.stackgoblin.stackgoblin.service;

import com.stackgoblin.stackgoblin.model.LanguageTag;
import com.stackgoblin.stackgoblin.repository.LanguageTagRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StackGoblinService {
    private final LanguageTagRepository languageTagRepository;
    private final RandomStringGenerator generator;

    StackGoblinService(LanguageTagRepository languageTagRepository) {
        this.languageTagRepository = languageTagRepository;
        this.generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
    }

    public LanguageTag addRandomLanguage() {
        LanguageTag newTag = new LanguageTag();
        newTag.setName(generator.generate(10));
        newTag.setDisplayName(generator.generate(10));
        newTag.setDescription(generator.generate(30));
        newTag.setType(LanguageTag.TYPE.PROGRAMMING);

        Mono<LanguageTag>  result = languageTagRepository.save(newTag);

        return result.block();
    }

    public Flux<LanguageTag> returnAll() {
        return languageTagRepository.findAll();
    }
}
