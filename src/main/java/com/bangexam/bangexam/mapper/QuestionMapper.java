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
}
