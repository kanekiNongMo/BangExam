package com.bangexam.bangexam.util;

import com.bangexam.bangexam.model.Question;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionUtil {

    public static List<Question> getQuestion(File file) {

        List<Question> questions = new ArrayList<Question>();
        Question question = new Question();

        try (InputStream inp = new FileInputStream(file)) {
            XSSFWorkbook wb = new XSSFWorkbook(inp);
            int size = wb.getNumberOfSheets();
            for (int i = 0; i < size; i++) {
                XSSFSheet sheet = wb.getSheetAt(i);
                int rowNumber = sheet.getPhysicalNumberOfRows();
                for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++) {
                    if (rowIndex == 0) {
                        continue;
                    }
                    XSSFRow row = sheet.getRow(rowIndex);
                    question = new Question();
                    for (int cellIndex = 0; cellIndex < 9; cellIndex++) {
                        XSSFCell cell = row.getCell(cellIndex);
                        cell.setCellType(CellType.STRING);
                        switch (cellIndex) {
                            case 0:
                                question.setQuestionInfo(cell.getStringCellValue());
                                break;
                            case 1:
                                question.setType(Integer.valueOf(cell.getStringCellValue()));
                                break;
                            case 2:
                                question.setMajorType(Integer.valueOf(cell.getStringCellValue()));
                                break;
                            case 3:
                                question.setOptionA(cell.getStringCellValue());
                                break;
                            case 4:
                                question.setOptionB(cell.getStringCellValue());
                                break;
                            case 5:
                                question.setOptionC(cell.getStringCellValue());
                                break;
                            case 6:
                                question.setOptionD(cell.getStringCellValue());
                                break;
                            case 7:
                                question.setAnswer(cell.getStringCellValue());
                                break;
                            case 8:
                                question.setAnswerExplain(cell.getStringCellValue());
                                break;
                        }
                    }
                    questions.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
