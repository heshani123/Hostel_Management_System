package lk.ijse.hostelmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginFormController {
    public Button btnLogin;
    public TextField txtUserName;
    public Label txtPassword;
    public TextField txtPasswerd;
    public Label lblWrong;
    public AnchorPane LogingFormContext;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource() == btnLogin){
            String username =  txtUserName.getText();
            String password = txtPasswerd.getText();
            if(username.equalsIgnoreCase("hostel")&& password.equalsIgnoreCase("1234")){
                System.out.println(("Login success"));
                Stage window = (Stage) LogingFormContext.getScene().getWindow();
               window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashbordForm.fxml"))));
            }else if
            (txtUserName.getText().isEmpty() && txtPasswerd.getText().isEmpty()){
                lblWrong.setText("Please entry your data.");
            }else {

                lblWrong.setText("Worng username or password");
            }
        }
    }
}
