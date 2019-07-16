package com.bangexam.bangexam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:53
 */

@Data
@Entity
@Table(name = "exam_paper")
public class ExamPaper implements Serializable {

    private static final long serialVersionUID = 3529759253244958745L;

    @Id
    @Column(name = "paper_no")
    private Integer paperNo;

    /**
     * majorType = 1为java
     * majorType = 2为测试
     */
    @Column(name = "major_type")
    private Integer majorType;

    @Column(name = "paper_name")
    private String paperName;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String updateTime;

    @Column(name = "status")
    private Integer status;

}
