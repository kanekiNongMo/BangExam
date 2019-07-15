package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.ExamPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:51
 */
@Mapper
public interface ExamPaperMapper {
    /**
     * 获取所有试卷数量
     *
     * @return 试卷总数
     */
    @Select("select count(*) from exam_paper")
    Integer countAllPapers();

    /**
     * 分页获取试卷信息
     *
     * @param startPosition 开始位置
     * @param limit         最多返回数据行数
     * @return 试卷集合
     */
    List<ExamPaper> getAllPaperByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit);

    /**
     * 新增试卷
     *
     * @param examPaper 试卷信息
     * @return 成功执行行数
     */
    int savePaper(ExamPaper examPaper);

    /**
     * 根据试卷编号查询试卷信息
     *
     * @param paperNo 试卷编号
     * @return 试卷信息
     */
    ExamPaper getPaperByPaperNo(Integer paperNo);

    /**
     * 修改试卷
     *
     * @param examPaper 试卷信息
     * @return 成功执行行数
     */
    int updatePaper(ExamPaper examPaper);
}
