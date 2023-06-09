package lk.ijse.hostelmanagementsystem.entity.custom;

import lk.ijse.hostelmanagementsystem.entity.SuperEntityy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Room implements SuperEntityy {
    @Id
    private String id;
    private String availability;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RoomTypeId")
    private RoomType roomType;

    @OneToMany(mappedBy = "room",targetEntity = StudentRoom.class)
    private List<StudentRoom> studentRooms;
}
