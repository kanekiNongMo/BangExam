package com.bangexam.bangexam.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class PaperVO implements Serializable {
    private static final long serialVersionUID = 3529759253244958745L;

    @Id
    private Integer paperNo;

    private Integer majorType;

    private String paperName;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String updateTime;

    private Integer status;

    private Integer number;
}
