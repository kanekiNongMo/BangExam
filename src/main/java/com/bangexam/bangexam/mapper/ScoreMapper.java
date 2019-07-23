package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:52
 */
@Mapper
public interface ScoreMapper {
    /**
     * 查询每个用户对题总数
     *
     * @param start     开始位置
     * @param limit     取几条数据
     * @param majorType 类型
     * @return 每个用户对题总数并排序
     */
    List<Score> getUserScoreTrueQuestionNum(@Param("start") Integer start,
                                            @Param("limit") Integer limit,
                                            @Param("majorType") Integer majorType);

    /**
     * 查询成绩记录
     *
     * @param userId 用户编号
     * @return 该用户成绩
     */
    List<Score> record(Integer userId);



}
