package com.clickerclass.testanswers.service;

import com.clickerclass.testanswers.model.TestAnswerModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestAnswerService {

    Mono<TestAnswerModel> findById(String id);

    Flux<TestAnswerModel> findByCourseId(String id);

    Flux<TestAnswerModel> findByClientId(String id);

    Flux<TestAnswerModel> findByClientIdAndCourseId(String clientId, String courseId);

    Mono<TestAnswerModel> save(TestAnswerModel testAnswerModelMono);
}
