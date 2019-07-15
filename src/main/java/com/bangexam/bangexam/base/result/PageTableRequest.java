package com.bangexam.bangexam.base.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 此类用于分页
 *
 * @author kaneki
 * @date 2019/7/13 17:09
 */
@Data
public class PageTableRequest implements Serializable {

    private static final long serialVersionUID = 1157327366454087186L;

    private Integer page;
    private Integer limit;
    private Integer offset;

    public void countOffset() {
        if (null == this.page || null == this.limit) {
            this.offset = 0;
            return;
        }
        this.offset = (this.page - 1) * limit;
    }
}
