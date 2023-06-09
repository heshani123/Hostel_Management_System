package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.hostelmanagementsystem.dto.custom.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.custom.Student;
import lk.ijse.hostelmanagementsystem.service.coustom.StudentService;
import lk.ijse.hostelmanagementsystem.service.coustom.impl.StudentServiceImpl;

public class AddStudentFormController {

    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtCity;
    public JFXTextField txtGmail;

    private StudentService studentService;

    public void initialize(){
        studentService =new StudentServiceImpl();
    }

    public StudentDTO collectData(){
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAAddress.getText();
        String contact = txtContactNo.getText();
        String city = txtCity.getText();
        String gmail = txtGmail.getText();

        StudentDTO student =new StudentDTO(id,name,address,contact,city,gmail,null);
        return student;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        StudentDTO studentDTO = collectData();
        StudentDTO save =studentService.save(studentDTO);
        if(save!=null){
            new Alert(Alert.AlertType.INFORMATION,"Student Added Success").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Student Added Failed").show();
        }
    }
}
