package com.bangexam.bangexam.service;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.Question;

import java.io.File;

public interface QuestionService {

    Result<Question> saveQuestion(Question question);

    Question getQuestionByQuestionNo(Integer questionNo);

    Result<Question> getAllQuestionByPage(Integer offset, Integer limit);

    Result<Question> getListByMajorType(Integer offset, Integer limit, Integer majorType);

    Result<Question> updateQuestion(Question question);

    int deleteQuestion(Integer questionNo);

    /**
     * 根据专业和题目类型查询题目
     *
     * @param majorType 专业类型
     * @param type      题目类型
     * @param offset    开始位置
     * @param limit     最多返回数据行数
     * @return 返回数据
     */
    Result<Question> search(Integer majorType, Integer type, Integer offset, Integer limit);

    Result upQuestions(File dest);

    Result<Question> deleteQuestions(int[] questionIds);

    Integer getCountQuestion(String genre);
}
