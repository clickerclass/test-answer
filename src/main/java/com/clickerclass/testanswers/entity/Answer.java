package com.clickerclass.testanswers.entity;

import lombok.Data;

@Data
public class Answer {
    private String id;
    private String description;
    private boolean isSelect;
    private boolean trueOption;
}
