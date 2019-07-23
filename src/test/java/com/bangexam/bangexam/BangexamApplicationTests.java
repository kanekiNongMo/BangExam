package com.bangexam.bangexam;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.mapper.ExamPaperMapper;
import com.bangexam.bangexam.mapper.ScoreMapper;
import com.bangexam.bangexam.mapper.UserAnswerMapper;
import com.bangexam.bangexam.model.Answer;
import com.bangexam.bangexam.model.ExamPaper;
import com.bangexam.bangexam.model.Question;
import com.bangexam.bangexam.model.Score;
import com.bangexam.bangexam.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BangexamApplicationTests {

    @Autowired
    private PaperService paperService;

    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Resource
    private ScoreMapper scoreMapper;

    @Resource
    private UserAnswerMapper userAnswerMapper;


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
        System.out.println("code:" + e.getCode() + " msg:" + e.getMsg());
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
        System.out.println("code:" + e.getCode() + " msg:" + e.getMsg());
    }

    @Test
    public void getQuestionTest() {
        List<Question> questionList = paperService.getPaperQuestion(1);
        questionList.forEach(System.out::println);
    }

    @Test
    public void getTrueNumTest() {
        List<Score> scoreList = scoreMapper.getUserScoreTrueQuestionNum(0, 3, null);
        scoreList.forEach(System.out::println);
    }

    @Test
    public void recordTest() {
        List<Score> scoreList = scoreMapper.record(1);
        scoreList.forEach(System.out::println);
    }

    @Test
    public void scoreDetailTest() {
        List<Answer> scoreList = userAnswerMapper.scoreDetail(1);
        scoreList.forEach(System.out::println);
    }

}
