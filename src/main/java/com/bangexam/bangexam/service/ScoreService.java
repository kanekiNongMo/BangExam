package com.bangexam.bangexam.service;

import com.bangexam.bangexam.model.Score;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/19 10:55
 */
public interface ScoreService {
    /**
     * 查询每个用户对题总数
     *
     * @param start 开始位置
     * @param limit 取几条数据
     * @param majorType 类型
     * @return 每个用户对题总数并排序
     */
    List<Score> getUserScoreTrueQuestionNum(Integer start, Integer limit, Integer majorType);
}
