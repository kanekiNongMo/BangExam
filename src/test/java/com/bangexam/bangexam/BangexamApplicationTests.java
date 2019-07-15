package com.bangexam.bangexam;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BangexamApplicationTests {

    @Autowired
    private PaperService paperService;

    @Test
    public void paperPageTest() {
        Result<ExamPaper> e = paperService.getAllPaperByPage(1, 4);
        System.out.println("Code and Count:" + e.getCode() + ":" + e.getCount());
        List<ExamPaper> lists = e.getDatas();
        for (ExamPaper list : lists) {
            System.out.println("list:" + list);
        }
    }

    @Test
    public void savePaperTest() {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setPaperName("2020java");
        examPaper.setMajorType(2);
        Result<ExamPaper> e = paperService.savePaper(examPaper);
        System.out.println("code:"+e.getCode()+" msg:"+e.getMsg());
    }

    @Test
    public void getPaperByPaperNoTest() {
        ExamPaper examPaper = paperService.getPaperByPaperNo(1);
        System.out.println(examPaper);
    }

    @Test
    public void editPaperTest() {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setPaperName("2020java");
        examPaper.setMajorType(2);
        examPaper.setPaperNo(13);
        Result<ExamPaper> e = paperService.updatePaper(examPaper);
        System.out.println("code:"+e.getCode()+" msg:"+e.getMsg());
    }

}
