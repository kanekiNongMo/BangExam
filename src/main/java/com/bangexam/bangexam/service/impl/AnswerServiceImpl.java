package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.mapper.UserAnswerMapper;
import com.bangexam.bangexam.model.Answer;
import com.bangexam.bangexam.service.AnswerService;
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
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private UserAnswerMapper userAnswerMapper;

    @Override
    public List<Answer> scoreDetail(Integer scoreId) {
        return userAnswerMapper.scoreDetail(scoreId);
    }
}
