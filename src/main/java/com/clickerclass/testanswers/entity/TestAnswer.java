package com.clickerclass.testanswers.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@Document
public class TestAnswer {
    @Id
    private String id;
    private String name;
    private Date creationDate;
    private String clientId;
    private String courseId;
    private String testId;
    private Set<Question> questionsTests;
    private Double results;
}
