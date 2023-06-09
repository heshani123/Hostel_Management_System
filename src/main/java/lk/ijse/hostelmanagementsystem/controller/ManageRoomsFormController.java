package lk.ijse.hostelmanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import lk.ijse.hostelmanagementsystem.dto.custom.RoomDTO;
import lk.ijse.hostelmanagementsystem.dto.custom.RoomTypeDTO;
import lk.ijse.hostelmanagementsystem.service.coustom.RoomService;
import lk.ijse.hostelmanagementsystem.service.coustom.RoomTypeService;
import lk.ijse.hostelmanagementsystem.service.coustom.impl.RoomTypeServiceImpl;

import java.util.List;

public class ManageRoomsFormController {
    public ComboBox<RoomTypeDTO> cbRoomType;
    public TextField txtAvailability;
    public TextField txtDecription;
    public TextField txtRoomTypeId;
    public TextField txtKeyMoney;

    private RoomTypeService roomTypeService;
    private RoomService roomService;

    public void initialize(){
        roomTypeService=new RoomTypeServiceImpl();
        setComboBox();


    }

    public void setComboBox(){
        List<RoomTypeDTO> all= roomTypeService.getAll();
        cbRoomType.setItems(FXCollections.observableArrayList(all));

    }
    public void visualizeComboBox(){
        cbRoomType.setConverter(new StringConverter<RoomTypeDTO>() {
            @Override
            public String toString(RoomTypeDTO object) {
                if (object==null)return null;
                return object.getDescription();
            }

            @Override
            public RoomTypeDTO fromString(String string) {
                return null;
            }
        });
    }
    public void btnAddRoomOnAction(ActionEvent actionEvent) {
        RoomTypeDTO roomTypeDTO = collectRoomTypeDTO();
        RoomTypeDTO save =roomTypeService.save(roomTypeDTO);
        if (save!=null){
            new Alert(Alert.AlertType.INFORMATION,"Data Added").show();;
            setComboBox();
        }else{
            new Alert(Alert.AlertType.ERROR,"Data Added Failed").show();
        }
    }
    public void btnDeleteRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnAddRoomTypeOnAction(ActionEvent actionEvent) {

        RoomTypeDTO roomTypeDTO =collectRoomTypeDTO();
        RoomTypeDTO save =roomTypeService.save(roomTypeDTO);
        if (save!=null){
            new Alert(Alert.AlertType.INFORMATION,"Data Added").show();
            setComboBox();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Data Added Failed").show();
        }
    }

    public void btnUpdateRoomTypeOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteRoomTypeOnAction(ActionEvent actionEvent) {

    }

    public RoomTypeDTO collectRoomTypeDTO(){
        String roomTypeId = txtRoomTypeId.getText();
        String description = txtDecription.getText();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());

        return new RoomTypeDTO(roomTypeId,keyMoney,description,null);

    }
    public RoomDTO collectRoomDTO(){
        String id = txtRoomTypeId.getText();
        String availability = txtAvailability.getText();
        RoomTypeDTO roomType = cbRoomType.getSelectionModel().getSelectedItem();
        
        return new RoomDTO(id,availability,roomType,null);
    }
}
