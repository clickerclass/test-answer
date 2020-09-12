package com.clickerclass.testanswers.config;

import com.clickerclass.testanswers.handler.TestAnswerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(TestAnswerHandler testAnswerHandler) {
        return RouterFunctions.route(GET("/api/testAnswer/findById"), testAnswerHandler::findById)
                .andRoute(GET("/api/testAnswer/findByClientId"), testAnswerHandler::findByClientId)
                .andRoute(GET("/api/testAnswer/findByCourseId"), testAnswerHandler::findByCourseId)
                .andRoute(GET("/api/testAnswer/findByClientIdAndCourseId"), testAnswerHandler::findByClientIdAndCourseId)
                .andRoute(POST("/api/testAnswer"), testAnswerHandler::save);
    }
}
