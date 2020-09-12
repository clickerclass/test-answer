package com.clickerclass.testanswers.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Question {
    private String id;
    private String description;
    private Set<Answer> answers;

}
