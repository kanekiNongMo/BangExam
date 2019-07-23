package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.Answer;
import com.bangexam.bangexam.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author kaneki
 * @date 2019/7/19 10:57
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Resource
    private AnswerService answerService;

    @RequestMapping("/scoreDetail")
    @ResponseBody
    public Result<Answer> scoreDetail(Integer scoreId) {
        return null == scoreId ? Result.failure() : Result.success(answerService.scoreDetail(scoreId));
    }

}
