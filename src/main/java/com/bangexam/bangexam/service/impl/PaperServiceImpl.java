package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.mapper.ExamPaperMapper;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kaneki
 * @date 2019/7/14 13:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl implements PaperService {
    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Override
    public Result<ExamPaper> getAllPaperByPage(Integer offset, Integer limit) {
        return Result.success(examPaperMapper.countAllPapers(), examPaperMapper.getAllPaperByPage(offset, limit));
    }

    @Override
    public Result<ExamPaper> savePaper(ExamPaper examPaper) {
        return examPaperMapper.savePaper(examPaper) > 0 ? Result.success() : Result.failure();
    }

    @Override
    public ExamPaper getPaperByPaperNo(Integer paperNo) {
        return examPaperMapper.getPaperByPaperNo(paperNo);
    }

    @Override
    public Result<ExamPaper> updatePaper(ExamPaper examPaper) {
        return examPaperMapper.updatePaper(examPaper) > 0 ? Result.success() : Result.failure();
    }
}
