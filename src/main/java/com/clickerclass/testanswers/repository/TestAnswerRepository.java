package com.clickerclass.testanswers.repository;

import com.clickerclass.testanswers.entity.TestAnswer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TestAnswerRepository extends ReactiveCrudRepository<TestAnswer, String> {
    Flux<TestAnswer> findByCourseId(String id);

    Flux<TestAnswer> findByClientId(String id);

    Flux<TestAnswer> findByClientIdAndCourseId(String clientId, String courseId);

}
