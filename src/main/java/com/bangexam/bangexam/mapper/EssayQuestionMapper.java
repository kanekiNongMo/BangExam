package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.EssayQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:31
 */
@Mapper
public interface EssayQuestionMapper {

    /**
     * 查询所有问答题
     * @return 所有问答题
     */
    List<EssayQuestion> findAllEssayQuestion();
}
