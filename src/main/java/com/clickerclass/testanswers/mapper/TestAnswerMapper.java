package com.clickerclass.testanswers.mapper;

import com.clickerclass.testanswers.entity.TestAnswer;
import com.clickerclass.testanswers.model.TestAnswerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestAnswerMapper {
    TestAnswerModel toModel(TestAnswer testAnswer);

    TestAnswer toEntity(TestAnswerModel testAnswerModel);
}
