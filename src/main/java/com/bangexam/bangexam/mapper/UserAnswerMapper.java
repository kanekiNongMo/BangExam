package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:52
 */
@Mapper
public interface UserAnswerMapper {
    /**
     * 成绩详情
     *
     * @param scoreId 成绩编号
     * @return 用户成绩
     */
    List<Answer> scoreDetail(Integer scoreId);
}
