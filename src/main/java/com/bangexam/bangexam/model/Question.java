package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/15 13:44
 */
@Data
@Entity
@Table(name = "question")
public class Question implements Serializable {
    private static final long serialVersionUID = -7112853022131957405L;

    @Id
    @Column(name = "question_no")
    private Integer questionNo;

    @Column(name = "type")
    private Integer type;

    @Column(name = "major_type")
    private Integer majorType;

    @Column(name = "question_info")
    private String questionInfo;

    @Column(name = "option_a")
    private String optionA;

    @Column(name = "option_b")
    private String optionB;

    @Column(name = "option_c")
    private String optionC;

    @Column(name = "option_d")
    private String optionD;

    @Column(name = "answer")
    private String answer;

    @Column(name = "answer_explain")
    private String answerExplain;
}
