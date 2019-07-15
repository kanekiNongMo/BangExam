package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:49
 */
@Data
@Entity
@Table(name = "single_choice_question")
public class SingleChoiceQuestion implements Serializable {

    private static final long serialVersionUID = -2134039260950234565L;

    @Id
    @Column(name = "question_no")
    private Integer questionNo;

    @Column(name = "type_id")
    private Integer type;

    @Column(name = "question_info")
    private String questionInfo;

    @Column(name = "option_a")
    private String aOption;

    @Column(name = "option_b")
    private String bOption;

    @Column(name = "option_c")
    private String cOption;

    @Column(name = "option_d")
    private String dOption;

    @Column(name = "answer")
    private String answer;

    @Column(name = "explain")
    private String explain;

}
