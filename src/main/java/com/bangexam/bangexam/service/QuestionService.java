package com.bangexam.bangexam.service;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.Question;

import java.io.File;

public interface QuestionService {

    Result<Question> saveQuestion(Question question);

    Question getQuestionByQuestionNo(Integer questionNo);

    Result<Question> getAllQuestionByPage(Integer offset, Integer limit);

    Result<Question> updateQuestion(Question question);

    int deleteQuestion(Integer questionNo);

    Result upQuestions(File dest);
}
