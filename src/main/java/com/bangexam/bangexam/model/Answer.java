package com.bangexam.bangexam.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/22 12:36
 */
@Data
public class Answer implements Serializable {

    private static final long serialVersionUID = 1801692856306247122L;

    private Integer id;
    private String userAnswer;
    private Question question;
}
