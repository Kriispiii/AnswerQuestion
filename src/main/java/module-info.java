module com.git.krispi.answerquestion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.git.krispi.answerquestion to javafx.fxml;
    exports com.git.krispi.answerquestion;
}