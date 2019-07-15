package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 14:17
 */
@Data
@Entity
@Table(name = "exam_user")
public class User implements Serializable {

    private static final long serialVersionUID = 9213474260004583440L;
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_status")
    private Integer status;
}
