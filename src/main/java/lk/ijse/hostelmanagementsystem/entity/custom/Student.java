package lk.ijse.hostelmanagementsystem.entity.custom;

import lk.ijse.hostelmanagementsystem.entity.SuperEntityy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Student implements SuperEntityy {
    @Id

    private  String id;
    private  String name;
   private String address;
   private  String city;
   private  String contact;
   private  String gamil;

   @OneToMany(targetEntity = Student.class,mappedBy = "student")
   private List<StudentRoom> studentRooms;

}
