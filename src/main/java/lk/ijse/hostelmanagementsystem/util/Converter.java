package lk.ijse.hostelmanagementsystem.util;

import lk.ijse.hostelmanagementsystem.dto.custom.RoomDTO;
import lk.ijse.hostelmanagementsystem.dto.custom.RoomTypeDTO;
import lk.ijse.hostelmanagementsystem.dto.custom.StudentDTO;
import lk.ijse.hostelmanagementsystem.dto.custom.StudentRoomDTO;
import lk.ijse.hostelmanagementsystem.entity.custom.Room;
import lk.ijse.hostelmanagementsystem.entity.custom.RoomType;
import lk.ijse.hostelmanagementsystem.entity.custom.Student;
import lk.ijse.hostelmanagementsystem.entity.custom.StudentRoom;

import java.sql.Date;


public class Converter {
    private static Converter converter;
    private Converter(){}
    public static Converter getInstance(){
        if (converter==null)converter=new Converter();
        return converter;
    }

    public Student toOnlyStudent(StudentDTO student){
        return new Student(student.getId(),student.getName(),student.getAddress(),student.getCity(),student.getContact(),student.getGmail(),null);
    }

    public StudentDTO toOnlyStudentDTO(Student student){
        return new StudentDTO(student.getId(),student.getName(),student.getAddress(),student.getCity(),student.getContact(),student.getGamil(),null);
    }

    public Room toOnlyRoom(RoomDTO room){
        return new Room(room.getId(),room.getAvailability(),null,null);
    }

    public RoomDTO toOnlyRoomDTO(Room room){
        return new RoomDTO(room.getId(),room.getAvailability(),null,null);
    }
    public RoomType toOnlyRoomType(RoomTypeDTO roomType){
        return  new RoomType(roomType.getId(),roomType.getKey_money(),roomType.getDescription(),null);
    }

    public RoomTypeDTO toOnlyRoomTypeDTO(RoomType roomType){
        return new RoomTypeDTO(roomType.getId(), roomType.getKeymoney(), roomType.getDescrittion(),null);
    }

    public StudentRoom toOnlyStudentRoom(StudentRoomDTO studentRoom){
        return new StudentRoom(studentRoom.getId(),studentRoom.getAdvance(),Date.valueOf(studentRoom.getPaymentDate()),null,null);
    }

    public StudentRoomDTO toOnlyStudentRoomDTO(StudentRoom studentRoom){
        return new StudentRoomDTO(studentRoom.getId(),studentRoom.getAdvance(),studentRoom.getPaymentDate().toLocalDate(),null,null);
    }



}