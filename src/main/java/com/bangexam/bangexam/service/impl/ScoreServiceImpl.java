package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.mapper.ScoreMapper;
import com.bangexam.bangexam.model.Score;
import com.bangexam.bangexam.service.ScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/19 10:55
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> getUserScoreTrueQuestionNum(Integer start, Integer limit, Integer majorType) {
        return scoreMapper.getUserScoreTrueQuestionNum(start, limit, majorType);
    }
}
