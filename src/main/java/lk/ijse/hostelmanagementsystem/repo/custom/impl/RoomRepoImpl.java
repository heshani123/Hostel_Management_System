package lk.ijse.hostelmanagementsystem.repo.custom.impl;

import lk.ijse.hostelmanagementsystem.entity.custom.Room;
import lk.ijse.hostelmanagementsystem.entity.custom.Student;
import lk.ijse.hostelmanagementsystem.repo.custom.RoomRepo;
import org.hibernate.Session;

import java.util.List;

public class RoomRepoImpl implements RoomRepo {
    @Override
    public Room search(String s, Session session) throws Exception {
        return session.get(Room.class,s);
    }

    @Override
    public void delete(Room room, Session session) throws Exception {
        session.delete(room);
    }

    @Override
    public void update(Room room, Session session) throws Exception {
        session.update(room);
    }

    @Override
    public Room save(Room room, Session session) throws Exception {
        String id =(String)session.save (room);
        room.setId(id);
        return room;
    }

    @Override
    public List<Room> getAll(Session session) throws Exception {
        return session.createCriteria(Room.class).list();
    }
}
