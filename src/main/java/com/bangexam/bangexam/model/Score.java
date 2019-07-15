package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:55
 */
@Data
@Entity
@Table(name = "score")
public class Score implements Serializable {

    private static final long serialVersionUID = -3111453812806846809L;

    @Id
    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "score")
    private String score;

    @Column(name = "exam_time")
    private String examTime;


    @Column(name = "true_number")
    private String trueNumber;

    @Column(name = "false_number")
    private String falseNumber;
}
