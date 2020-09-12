package com.clickerclass.testanswers.handler;

import com.clickerclass.testanswers.model.TestAnswerModel;
import com.clickerclass.testanswers.service.TestAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class TestAnswerHandler {
    private final TestAnswerService testAnswerService;
    private final Validator validator;

    public TestAnswerHandler(@Autowired Validator validator, @Autowired TestAnswerService testAnswerService) {
        this.testAnswerService = testAnswerService;
        this.validator = validator;
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Optional<String> idOptional = request.queryParam("id");
        if (idOptional.isEmpty()) {
            return ServerResponse.badRequest().build();
        }
        return this.testAnswerService.findById(idOptional.get())
                .flatMap(testAnswerModel -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue(testAnswerModel)));
    }

    public Mono<ServerResponse> findByClientId(ServerRequest request) {
        Optional<String> clientIdOptional = request.queryParam("clientId");
        if (clientIdOptional.isEmpty()) {
            return ServerResponse.badRequest().build();
        }
        return this.testAnswerService.findByClientId(clientIdOptional.get())
                .collectList()
                .flatMap(testAnswerModel -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue(testAnswerModel)));
    }

    public Mono<ServerResponse> findByCourseId(ServerRequest request) {
        Optional<String> courseIdOptional = request.queryParam("courseId");
        if (courseIdOptional.isEmpty()) {
            return ServerResponse.badRequest().build();
        }
        return this.testAnswerService.findByCourseId(courseIdOptional.get())
                .collectList()
                .flatMap(testAnswerModel -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue(testAnswerModel)));
    }

    public Mono<ServerResponse> findByClientIdAndCourseId(ServerRequest request) {
        Optional<String> clientIdOptional = request.queryParam("clientId");
        Optional<String> courseIdOptional = request.queryParam("courseId");
        if (courseIdOptional.isEmpty() || clientIdOptional.isEmpty()) {
            return ServerResponse.badRequest().build();
        }
        return this.testAnswerService
                .findByClientIdAndCourseId(clientIdOptional.get(), courseIdOptional.get())
                .collectList()
                .flatMap(testAnswerModel -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue(testAnswerModel)));
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<TestAnswerModel> testAnswerModelMono = request.bodyToMono(TestAnswerModel.class);
        return testAnswerModelMono.flatMap(testAnswerModel -> {
            Errors errors = new BeanPropertyBindingResult(testAnswerModel, TestAnswerModel.class.getName());
            validator.validate(testAnswerModel, errors);
            if (errors.hasErrors()) {
                return ServerResponse.badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(errors.getFieldErrors()));
            }
            return this.testAnswerService.save(testAnswerModel).flatMap(testAnswerModel1 -> ServerResponse.ok().body(BodyInserters.fromValue(testAnswerModel1)));
        });

    }

}
