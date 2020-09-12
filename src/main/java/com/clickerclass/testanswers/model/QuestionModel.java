package com.clickerclass.testanswers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class QuestionModel {
    private String id;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double result;
    private Set<AnswerModel> answers;

}
