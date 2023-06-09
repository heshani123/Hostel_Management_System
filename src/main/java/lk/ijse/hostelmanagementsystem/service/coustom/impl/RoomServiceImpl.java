package lk.ijse.hostelmanagementsystem.service.coustom.impl;

import lk.ijse.hostelmanagementsystem.dto.custom.RoomDTO;
import lk.ijse.hostelmanagementsystem.entity.custom.Room;
import lk.ijse.hostelmanagementsystem.repo.custom.RoomRepo;
import lk.ijse.hostelmanagementsystem.repo.custom.impl.RoomRepoImpl;
import lk.ijse.hostelmanagementsystem.service.coustom.RoomService;
import lk.ijse.hostelmanagementsystem.util.Converter;
import lk.ijse.hostelmanagementsystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    RoomRepo roomRepo;
    Converter converter;
    FactoryConfiguration factory;

    public RoomServiceImpl(){
        factory =FactoryConfiguration.getInstance();
        roomRepo =new RoomRepoImpl();
        converter = Converter.getInstance();
    }
    @Override
    public RoomDTO search(String s){
        Session session =factory.getSession();
        try {
            Room search = roomRepo.search(s,session);
            return converter.toOnlyRoomDTO(search);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean delete(RoomDTO roomDTO){
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Room room = converter.toOnlyRoom(roomDTO);
            roomRepo.delete(room,session);
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
    public boolean update(RoomDTO roomDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Room room = converter.toOnlyRoom(roomDTO);
            roomRepo.update(room,session);
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
    public RoomDTO save(RoomDTO roomDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Room room = converter.toOnlyRoom(roomDTO);
            Room save =roomRepo.save(room,session);
            transaction.commit();
            return converter.toOnlyRoomDTO(save);
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<RoomDTO> getAll(){
        Session session = factory.getSession();
        List<RoomDTO> list =new ArrayList<>();
        try{
            List<Room> all =roomRepo.getAll(session);
            for (Room room :all){
                list.add(converter.toOnlyRoomDTO(room));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}