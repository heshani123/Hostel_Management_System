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
public class RoomType implements SuperEntityy {
    @Id

    private String id;
    private double keymoney;
    private String descrittion;

    @OneToMany(targetEntity = Room.class,mappedBy = "roomType")
    private List<Room> rooms;
}
