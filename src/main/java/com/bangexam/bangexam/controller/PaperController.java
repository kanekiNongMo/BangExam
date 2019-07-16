package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.base.result.PageTableRequest;
import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kaneki
 * @date 2019/7/14 13:37
 */
@Slf4j
@Controller
@RequestMapping("/paper")
public class PaperController {
    @Resource
    private PaperService paperService;

    @GetMapping("/list")
    @ResponseBody
    public Result<ExamPaper> getUsers(PageTableRequest pageRequest) {
        pageRequest.countOffset();
        return paperService.getAllPaperByPage(pageRequest.getOffset(), pageRequest.getLimit());
    }

    @GetMapping("/add")
    public String addPaper(Model model) {
        model.addAttribute(new ExamPaper());
        return "paper/paper-add-edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<ExamPaper> savePaper(@RequestBody ExamPaper examPaper) {
        return examPaper == null ? Result.failure() : paperService.savePaper(examPaper);
    }

    @GetMapping("/edit")
    public String editPaper(Model model, ExamPaper examPaper) {
        if (examPaper == null) {
            return "null";
        }
        model.addAttribute(paperService.getPaperByPaperNo(examPaper.getPaperNo()));
        return "paper/paper-add-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Result<ExamPaper> updatePaper(@RequestBody ExamPaper examPaper) {
        log.info(examPaper.getPaperNo() + ":::::" + examPaper.getStatus());
        return paperService.updatePaper(examPaper);
    }

    @GetMapping("/delete")
    @ResponseBody
    public Result<ExamPaper> deletePaper(Integer paperNo) {
        return paperService.deletePaper(paperNo);
    }

    @GetMapping("/relate")
    public String toRelatePaper(Model model, ExamPaper examPaper) {
        log.info("examPaper::" + examPaper.getPaperNo());
        model.addAttribute(examPaper);
        return "paper/related-questions";
    }

    @PostMapping("/relate")
    @ResponseBody
    public Result<ExamPaper> relatedQuestions(Integer paperNo,@RequestParam("questionIds[]") int [] questionIds) {
        for (int i : questionIds) {
            log.info("questionIds::" +i);
        }
        log.info("paperNo ::" + paperNo);
        return paperService.relatedQuestions(paperNo, questionIds);
    }

}
