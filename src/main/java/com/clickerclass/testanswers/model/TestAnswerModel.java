package com.clickerclass.testanswers.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class TestAnswerModel {
    private String id;
    @NotEmpty
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date creationDate;
    @NotEmpty
    private String clientId;
    @NotEmpty
    private String courseId;
    @NotEmpty
    private String testId;
    @NotNull
    private Set<QuestionModel> questionsTests;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double results;
}
