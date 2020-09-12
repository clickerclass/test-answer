package com.clickerclass.testanswers.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnswerModel {
    @NotEmpty
    private String id;
    @NotEmpty
    private String description;
    @NotNull
    private Boolean isSelect;
    @NotNull
    private Boolean trueOption;
}
