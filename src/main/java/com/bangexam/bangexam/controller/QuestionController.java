package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.base.result.PageTableRequest;
import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.model.Question;
import com.bangexam.bangexam.service.PaperService;
import com.bangexam.bangexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * @author tyj
 * @date 2019/7/15 13:37
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private PaperService paperService;


    @GetMapping("/list")
    @ResponseBody
    public Result<Question> getQuestions(PageTableRequest pageRequest) {
        pageRequest.countOffset();
        return questionService.getAllQuestionByPage(pageRequest.getOffset(), pageRequest.getLimit());
    }


    /**
     * 打开添加考题页面
     */
    @GetMapping("/add" )
    public String addQuestion(Model model) {
        model.addAttribute(new Question());
        return "questions/questions-add-edit";
    }


    /**
     * 添加考题
     * @param question
     * @return
     */
    @PostMapping("/adds")
    @ResponseBody
    public Result<Question> saveQuestion(@RequestBody Question question) {
        System.out.println("---"+question);
        return question == null ? Result.failure() : questionService.saveQuestion(question);
    }

    @GetMapping("/edit")
    public String editPaper(Model model, Question question) {
        if (question == null) {
            return "null";
        }
        model.addAttribute(questionService.getQuestionByQuestionNo(question.getQuestionNo()));
        return "paper/paper-add-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Result<ExamPaper> updateQuestion(ExamPaper examPaper) {
        return examPaper == null ? Result.failure() : paperService.updatePaper(examPaper);
    }

}
