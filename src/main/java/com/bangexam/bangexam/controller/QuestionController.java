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
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * @author tyj
 * @date 2019/7/15 13:37
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    @ResponseBody
    public Result<Question> getQuestions(PageTableRequest pageRequest) {
        pageRequest.countOffset();
        return questionService.getAllQuestionByPage(pageRequest.getOffset(), pageRequest.getLimit());
    }


    /**
     * 打开添加考题页面
     */
    @GetMapping("/add")
    public String addQuestion(Model model) {
        model.addAttribute(new Question());
        return "questions/questions-add";
    }


    /**
     * 添加考题
     *
     * @param question
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result<Question> saveQuestion(@RequestBody Question question) {
        return question == null ? Result.failure() : questionService.saveQuestion(question);
    }

    @GetMapping("/edit")
    public String editQuestion(Model model, Question question) {
        if (question == null) {
            return "null";
        }
        model.addAttribute(questionService.getQuestionByQuestionNo(question.getQuestionNo()));
        return "questions/questions-add-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Result<Question> updateQuestion(@RequestBody Question question) {
        return question == null ? Result.failure() : questionService.updateQuestion(question);
    }

    @GetMapping("/delete")
    @ResponseBody
    public Result deleteQuestion(Question question) {
        System.out.println(question);
        int count = questionService.deleteQuestion(question.getQuestionNo());
        if (count > 0) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @GetMapping("/upload")
    public String upQuestion(Model model) {
        model.addAttribute(new Question());
        return "questions/questions-up";
    }


    /**
     * 批量上传考题
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public Result uploadQuestion(@RequestParam("file")MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure();
        }
        String fileName = file.getOriginalFilename();
        String filePath = "questions/";
        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return Result.success();
            //return questionService.upQuestions(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.failure();
    }
}
