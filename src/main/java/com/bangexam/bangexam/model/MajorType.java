package com.bangexam.bangexam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author kaneki
 * @date 2019/7/13 15:59
 */
@Data
@Entity
@Table(name = "major_type")
public class MajorType implements Serializable {

    private static final long serialVersionUID = 8787335119240594093L;

    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type_name")
    private Integer typeName;

}
