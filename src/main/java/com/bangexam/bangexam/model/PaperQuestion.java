package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/16 8:54
 */
@Data
@Entity
@Table(name = "paper_question")
public class PaperQuestion implements Serializable {

    private static final long serialVersionUID = -2857725304491084250L;
    @Id
    @Column(name = "paper_question_id")
    private Integer id;

    @Column(name = "paper_id")
    private Integer paperId;

    @Column(name = "question_id")
    private Integer questionId;


}
