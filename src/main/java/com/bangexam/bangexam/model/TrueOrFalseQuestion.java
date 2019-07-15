package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:51
 */
@Data
@Entity
@Table(name = "true_false_question")
public class TrueOrFalseQuestion implements Serializable {

    private static final long serialVersionUID = 3980300097499278393L;

    @Id
    @Column(name = "question_no")
    private Integer questionNo;

    @Column(name = "type_id")
    private Integer type;

    @Column(name = "question_info")
    private String questionInfo;

    @Column(name = "answer")
    private String answer;

    @Column(name = "explain")
    private String explain;
}
