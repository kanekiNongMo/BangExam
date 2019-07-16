package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    int saveQuestion(Question question);

    Question getQuestionByQuestionNo(Integer questionNo);

    @Select("select count(*) from question")
    Integer countAllPapers();

    List<Question> getAllQuestionByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit);

    /**
     * 根据各种类型获取题目
     *
     * @param majorType 专业类型
     * @param type      题目类型
     * @return 题目数量
     */
    Integer countQuestionByMajorTypeAndType(@Param("majorType") Integer majorType, @Param("type") Integer type);

    /**
     * 根据类型获取题目信息
     *
     * @param majorType 专业类型
     * @param type      题目类型
     * @param startPosition    开始位置
     * @param limit     最多数据行数
     * @return 题目信息
     */
    List<Question> getQuestionByMajorTypeAndType(@Param("majorType") Integer majorType, @Param("type") Integer type, @Param("startPosition") Integer startPosition, @Param("limit") Integer limit);
}
