package lk.ijse.hostelmanagementsystem.service.coustom.impl;

import lk.ijse.hostelmanagementsystem.dto.custom.RoomTypeDTO;
import lk.ijse.hostelmanagementsystem.entity.custom.RoomType;
import lk.ijse.hostelmanagementsystem.repo.custom.RoomTypeRepo;
import lk.ijse.hostelmanagementsystem.repo.custom.impl.RoomTypeRepoImpl;
import lk.ijse.hostelmanagementsystem.service.coustom.RoomTypeService;
import lk.ijse.hostelmanagementsystem.util.Converter;
import lk.ijse.hostelmanagementsystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {

    RoomTypeRepo roomTypeRepo;
    Converter converter;
    FactoryConfiguration factory;

    public RoomTypeServiceImpl(){
        factory =FactoryConfiguration.getInstance();
        roomTypeRepo =new RoomTypeRepoImpl();
        converter = Converter.getInstance();
    }
    @Override
    public RoomTypeDTO search(String s){
        Session session =factory.getSession();
        try {
            RoomType search = roomTypeRepo.search(s,session);
            return converter.toOnlyRoomTypeDTO(search);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean delete(RoomTypeDTO roomTypeDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            RoomType roomType = converter.toOnlyRoomType(roomTypeDTO);
            roomTypeRepo.delete(roomType,session);
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
    public boolean update(RoomTypeDTO roomTypeDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            RoomType roomType = converter.toOnlyRoomType(roomTypeDTO);
            roomTypeRepo.update(roomType,session);
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
    public RoomTypeDTO save(RoomTypeDTO roomTypeDTO){
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            RoomType roomType = converter.toOnlyRoomType(roomTypeDTO);
            RoomType save =roomTypeRepo.save(roomType,session);
            transaction.commit();
            return converter.toOnlyRoomTypeDTO(save);
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;    }

    @Override
    public List<RoomTypeDTO> getAll() {
        Session session = factory.getSession();
        List<RoomTypeDTO> list =new ArrayList<>();
        try{
            List<RoomType> all =roomTypeRepo.getAll(session);
            for (RoomType roomType :all){
                list.add(converter.toOnlyRoomTypeDTO(roomType));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}