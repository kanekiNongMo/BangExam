package com.bangexam.bangexam.util;

import com.bangexam.bangexam.model.Question;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.extractor.ExcelExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuestionUtil {

//    public List<Question> getQuestion (File file) {
//
//        List<Question> = new ArrayList<Question>();
//
//
//        try (InputStream inp = new FileInputStream(file)) {
//            HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
//            ExcelExtractor extractor = new ExcelExtractor(wb);
//
//            extractor.setFormulasNotResults(true);
//            extractor.setIncludeSheetNames(false);
//            String text = extractor.getText();
//            wb.close();
//        }
//    }

}
