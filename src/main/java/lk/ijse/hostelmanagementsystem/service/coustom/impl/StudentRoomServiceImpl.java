package lk.ijse.hostelmanagementsystem.service.coustom.impl;

import lk.ijse.hostelmanagementsystem.dto.custom.StudentRoomDTO;
import lk.ijse.hostelmanagementsystem.entity.custom.StudentRoom;
import lk.ijse.hostelmanagementsystem.repo.custom.StudentRoomRepo;
import lk.ijse.hostelmanagementsystem.repo.custom.impl.StudentRoomRepoImpl;
import lk.ijse.hostelmanagementsystem.service.coustom.StudentRoomService;
import lk.ijse.hostelmanagementsystem.util.Converter;
import lk.ijse.hostelmanagementsystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentRoomServiceImpl implements StudentRoomService {

    StudentRoomRepo studentRoomRepo;
    Converter converter;
    FactoryConfiguration factory;

    public StudentRoomServiceImpl(){
        factory =FactoryConfiguration.getInstance();
        studentRoomRepo =new StudentRoomRepoImpl();
        converter = Converter.getInstance();
    }
    @Override
    public StudentRoomDTO search(String s){
        Session session =factory.getSession();
        try {
            StudentRoom search = studentRoomRepo.search(s,session);
            return converter.toOnlyStudentRoomDTO(search);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean delete(StudentRoomDTO studentRoomDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            StudentRoom studentRoom = converter.toOnlyStudentRoom(studentRoomDTO);
            studentRoomRepo.delete(studentRoom,session);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(StudentRoomDTO studentRoomDTO){
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            StudentRoom studentRoom = converter.toOnlyStudentRoom(studentRoomDTO);
            studentRoomRepo.update(studentRoom,session);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public StudentRoomDTO save(StudentRoomDTO studentRoomDTO){
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            StudentRoom studentRoom = converter.toOnlyStudentRoom(studentRoomDTO);
            StudentRoom save =studentRoomRepo.save(studentRoom,session);
            transaction.commit();
            return converter.toOnlyStudentRoomDTO(save);
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<StudentRoomDTO> getAll(){
        Session session = factory.getSession();
        List<StudentRoomDTO> list =new ArrayList<>();
        try{
            List<StudentRoom> all =studentRoomRepo.getAll(session);
            for (StudentRoom studentRoom :all){
                list.add(converter.toOnlyStudentRoomDTO(studentRoom));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}