package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:58
 */
@Data
@Entity
@Table(name = "user_answer")
public class UserAnswer implements Serializable {

    private static final long serialVersionUID = -8553580665357231119L;

    @Id
    @Column(name = "answer_no")
    private Integer answerNo;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "answer")
    private String answer;

    @Column(name = "question_id")
    private String questionId;

}
