package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.model.Score;
import com.bangexam.bangexam.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/19 10:57
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @RequestMapping("/ranking")
    @ResponseBody
    public List<Score> getUserScoreTrueQuestionNum(Integer start, Integer limit, Integer majorType) {
        if (null != majorType && 0 == majorType) {
            majorType = null;
        }
        return scoreService.getUserScoreTrueQuestionNum(start, limit, majorType);
    }

}
