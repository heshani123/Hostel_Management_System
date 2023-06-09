package lk.ijse.hostelmanagementsystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageStudentFormController {
    public AnchorPane addStudentPane;

    public void initialize() throws IOException {
        addStudentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AddStudentForm.fxml")));
    }
}
