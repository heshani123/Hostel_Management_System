package lk.ijse.hostelmanagementsystem.entity.custom;

import lk.ijse.hostelmanagementsystem.entity.SuperEntityy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentRoom implements SuperEntityy {
    @Id

    private String id;
    private double advance;
    private Date paymentDate;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name ="student_id")
    private  Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="room_id")
    private  Room room;


}
