package lk.ijse.hostelmanagementsystem.repo.custom.impl;

import lk.ijse.hostelmanagementsystem.entity.custom.Student;
import lk.ijse.hostelmanagementsystem.entity.custom.StudentRoom;
import lk.ijse.hostelmanagementsystem.repo.custom.StudentRoomRepo;
import org.hibernate.Session;

import java.util.List;

public class StudentRoomRepoImpl implements StudentRoomRepo {

    @Override
    public StudentRoom search(String s, Session session) throws Exception {
        return session.get(StudentRoom.class,s);
    }

    @Override
    public void delete(StudentRoom studentRoom, Session session) throws Exception {
        session.delete(studentRoom);
    }

    @Override
    public void update(StudentRoom studentRoom, Session session) throws Exception {
        session.update(studentRoom);
    }

    @Override
    public StudentRoom save(StudentRoom studentRoom, Session session) throws Exception {
        String id =(String)session.save (studentRoom);
        studentRoom.setId(id);
        return studentRoom;
    }

    @Override
    public List<StudentRoom> getAll(Session session) throws Exception {
        return session.createCriteria(StudentRoom.class).list();
    }
}
