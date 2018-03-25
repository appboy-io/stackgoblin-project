package com.stackgoblin.stackgoblin.repository;

import com.stackgoblin.stackgoblin.model.LanguageTag;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTagRepository extends ReactiveMongoRepository<LanguageTag, Long> {
}
