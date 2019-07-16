package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.mapper.QuestionMapper;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.model.Question;
import com.bangexam.bangexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;


    /***
     *  添加考题
     * @param question
     * @return
     */
    @Override
    public Result<Question> saveQuestion(Question question) {
        System.out.println(question);
        return questionMapper.saveQuestion(question) > 0 ? Result.success() : Result.failure();
    }

    @Override
    public Question getQuestionByQuestionNo(Integer questionNo) {
        return questionMapper.getQuestionByQuestionNo(questionNo);
    }

    @Override
    public Result<Question> getAllQuestionByPage(Integer offset, Integer limit) {
        System.out.println(offset + "---------------" + limit);
        return Result.success(questionMapper.countAllPapers(), questionMapper.getAllQuestionByPage(offset, limit));
    }

    @Override
    public Result<Question> search(Integer majorType, Integer type, Integer offset, Integer limit) {
        return Result.success(questionMapper.countQuestionByMajorTypeAndType(majorType, type), questionMapper.getQuestionByMajorTypeAndType(majorType, type, offset, limit));
    }
}
