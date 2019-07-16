package com.bangexam.bangexam.service;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.ExamPaper;

/**
 * @author kaneki
 * @date 2019/7/14 13:40
 */
public interface PaperService {
    /**
     * 分页获取所有试卷信息
     *
     * @param offset 开始位置
     * @param limit  最多返回数据行数
     * @return 返回数据
     */
    Result<ExamPaper> getAllPaperByPage(Integer offset, Integer limit);

    /**
     * 添加试卷信息
     *
     * @param examPaper 试卷信息
     * @return 返回数据
     */
    Result<ExamPaper> savePaper(ExamPaper examPaper);

    /**
     * 根据试卷编号获取试卷信息
     *
     * @param paperNo 试卷编号
     * @return 试卷信息
     */
    ExamPaper getPaperByPaperNo(Integer paperNo);

    /**
     * 修改试卷信息
     *
     * @param examPaper 试卷信息
     * @return 返回数据
     */
    Result<ExamPaper> updatePaper(ExamPaper examPaper);

    /**
     * 删除试卷信息
     *
     * @param paperNo 试卷编号
     * @return 返回数据
     */
    Result<ExamPaper> deletePaper(Integer paperNo);

    /**
     * 试卷关联题目
     *
     * @param paperId     试卷编号
     * @param questionIds 题目编号数组
     * @return 成功执行行数
     */
    Result<ExamPaper> relatedQuestions(Integer paperId, int[] questionIds);
}
