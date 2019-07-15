package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:38
 */
@Data
@Entity
@Table(name = "essay_question")
public class EssayQuestion implements Serializable {

    private static final long serialVersionUID = -3470089824893377076L;

    @Id
    @Column(name = "question_no")
    private Integer questionNo;

    @Column(name = "type_id")
    private Integer type;

    @Column(name = "question_info")
    private String questionInfo;

    @Column(name = "answer")
    private String answer;

}
