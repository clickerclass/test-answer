package com.clickerclass.testanswers.service.impl;

import com.clickerclass.testanswers.mapper.TestAnswerMapper;
import com.clickerclass.testanswers.model.AnswerModel;
import com.clickerclass.testanswers.model.QuestionModel;
import com.clickerclass.testanswers.model.TestAnswerModel;
import com.clickerclass.testanswers.repository.TestAnswerRepository;
import com.clickerclass.testanswers.service.TestAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TestAnswerServiceImpl implements TestAnswerService {

    private final TestAnswerRepository testAnswerRepository;
    private final TestAnswerMapper testAnswerMapper;

    public TestAnswerServiceImpl(@Autowired TestAnswerRepository testAnswerRepository, @Autowired TestAnswerMapper testAnswerMapper) {
        this.testAnswerMapper = testAnswerMapper;
        this.testAnswerRepository = testAnswerRepository;
    }

    @Override
    public Mono<TestAnswerModel> findById(String id) {
        return this.testAnswerRepository.findById(id).map(this.testAnswerMapper::toModel);
    }

    @Override
    public Flux<TestAnswerModel> findByCourseId(String id) {
        return this.testAnswerRepository.findByCourseId(id).map(this.testAnswerMapper::toModel);
    }

    @Override
    public Flux<TestAnswerModel> findByClientId(String id) {
        return this.testAnswerRepository.findByClientId(id).map(this.testAnswerMapper::toModel);
    }

    @Override
    public Flux<TestAnswerModel> findByClientIdAndCourseId(String clientId, String courseId) {
        return this.testAnswerRepository.findByClientIdAndCourseId(clientId, courseId).map(this.testAnswerMapper::toModel);
    }

    @Override
    public Mono<TestAnswerModel> save(TestAnswerModel testAnswerModel) {
            double results = 0;
            for (QuestionModel questionModel : testAnswerModel.getQuestionsTests()) {
                int totalTrueOptions = 0;
                int totalPoints = 0;
                for (AnswerModel answer : questionModel.getAnswers()) {
                    if (answer.getTrueOption()) {
                        if (answer.getIsSelect()) {
                            totalPoints++;
                        }
                        totalTrueOptions++;
                    }
                }
                questionModel.setResult(totalPoints / (double) totalTrueOptions);
                results += questionModel.getResult();
            }
            testAnswerModel.setResults(results);
            return this.testAnswerRepository
                    .save(this.testAnswerMapper
                            .toEntity(testAnswerModel))
                    .map(this.testAnswerMapper::toModel);

    }
}
