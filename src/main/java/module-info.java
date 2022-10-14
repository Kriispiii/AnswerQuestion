module com.git.krispi.answerquestion {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;


    opens com.git.krispi.answerquestion to javafx.fxml;
    exports com.git.krispi.answerquestion;
}