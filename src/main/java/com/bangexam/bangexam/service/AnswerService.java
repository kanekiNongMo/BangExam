package com.bangexam.bangexam.service;

import com.bangexam.bangexam.model.Answer;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/19 10:55
 */
public interface AnswerService {
    /**
     * 成绩详情
     *
     * @param scoreId 成绩编号
     * @return 用户成绩
     */
    List<Answer> scoreDetail(Integer scoreId);
}
