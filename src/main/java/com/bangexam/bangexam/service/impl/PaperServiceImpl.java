package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.base.result.ResultCode;
import com.bangexam.bangexam.mapper.ExamPaperMapper;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.model.Question;
import com.bangexam.bangexam.service.PaperService;
import com.bangexam.bangexam.vo.PaperVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kaneki
 * @date 2019/7/14 13:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl implements PaperService {
    @Resource
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

    @Override
    public Result<ExamPaper> deletePaper(Integer paperNo) {
        return examPaperMapper.deletePaper(paperNo) > 0 ? Result.success() : Result.failure();
    }

    @Override
    public Result<ExamPaper> relatedQuestions(Integer paperId, int[] questionIds) {
        Map<String, Object> map = new HashMap<>(20);
        map.put("paperId", paperId);
        map.put("questionIds", questionIds);
        examPaperMapper.deletePaperQuestions(paperId);
        return examPaperMapper.relatedQuestions(map) > 0 ? Result.success() : Result.failure();
    }

    @Override
    public Result<PaperVO> getPaper(String paperType) {
        List<PaperVO> list =  examPaperMapper.getPaper(paperType);
        return Result.success(list);
    }

    @Override
    public List<Question> getPaperQuestion(Integer paperId) {
        return examPaperMapper.getPaperQuestion(paperId);
    }

}
