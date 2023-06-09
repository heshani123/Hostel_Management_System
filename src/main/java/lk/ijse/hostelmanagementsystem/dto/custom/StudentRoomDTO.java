package lk.ijse.hostelmanagementsystem.dto.custom;

import lk.ijse.hostelmanagementsystem.dto.SuperDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRoomDTO implements SuperDTO {
    private String id;
    private Double advance;
    private LocalDate paymentDate;


    private StudentDTO student;
    private RoomDTO room;
}