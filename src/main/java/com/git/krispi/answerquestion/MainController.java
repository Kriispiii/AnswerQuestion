package com.git.krispi.answerquestion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MainController {

    private Map<Integer, QuestionModel> map = new HashMap<>();

    private QuestionModel currentQuestion;

    private static int maxQuestion;

    @FXML
    private Label openLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private Label answerLabel1;

    @FXML
    private Label answerLabel2;

    @FXML
    private Label answerLabel3;

    @FXML
    private Label answerLabel4;

    @FXML
    private RadioButton check1;

    @FXML
    private RadioButton check2;

    @FXML
    private RadioButton check3;

    @FXML
    private RadioButton check4;

    @FXML
    private void checkQuestion(){

    }
    @FXML
    private void nextQuestion() {
        int r = maxQuestion;
        int rnd = (int) (Math.random() * ++r);
        if (rnd < 1) rnd = 1;
        currentQuestion = map.get(rnd - 1);
        questionLabel.setText(currentQuestion.getQuestion());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) list.add(i);
        Collections.shuffle(list);
        answerLabel1.setText(currentQuestion.getAnswer()[list.get(0)].getAnswerModel());
        answerLabel2.setText(currentQuestion.getAnswer()[list.get(1)].getAnswerModel());
        answerLabel3.setText(currentQuestion.getAnswer()[list.get(2)].getAnswerModel());
        answerLabel4.setText(currentQuestion.getAnswer()[list.get(3)].getAnswerModel());
    }

    @FXML
    private void openDocument(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter excelFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(excelFilter);
        fileChooser.getExtensionFilters().addAll(excelFilter);
        fileChooser.setTitle("Выбор файла");
        File file = fileChooser.showOpenDialog(stage);
        openLabel.setText(file.getAbsolutePath());
        try {
            OPCPackage pkg = OPCPackage.open(new FileInputStream(file));
            XSSFWorkbook myExcelBook = new XSSFWorkbook(pkg);
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
            fillMap(myExcelSheet);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fillMap(XSSFSheet sheet) {
        for (maxQuestion = 0; !checkIfRowIsEmpty(sheet.getRow(maxQuestion)); maxQuestion++) {
            AnswerModel[] answers = new AnswerModel[4];
            XSSFRow row = sheet.getRow(maxQuestion);
            for (int j = 1; j < 5; j++) {
                XSSFCell cell = row.getCell(j);
                AnswerModel answerModel;
                if (j == 1)
                    answerModel = new AnswerModel(true, cell.toString());
                else
                    answerModel = new AnswerModel(true, cell.toString());

                answers[j - 1] = answerModel;
            }
            XSSFCell cell = row.getCell(0);
            QuestionModel questionModel = new QuestionModel(cell.toString(), answers);
            map.put(maxQuestion, questionModel);
        }
    }

    private boolean checkIfRowIsEmpty(XSSFRow row) {
        if (row == null || row.getLastCellNum() <= 0) {
            return true;
        }
        XSSFCell cell = row.getCell((int) row.getFirstCellNum());
        if (cell == null || "".equals(cell.getRichStringCellValue().getString())) {
            return true;
        }
        return false;
    }

}