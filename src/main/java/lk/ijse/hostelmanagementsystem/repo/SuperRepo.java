package lk.ijse.hostelmanagementsystem.repo;

import lk.ijse.hostelmanagementsystem.entity.SuperEntityy;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface SuperRepo<T extends SuperEntityy,ID extends Serializable> {

    T search(ID id, Session session)throws Exception;
    void delete(T t, Session session)throws Exception;
    void update(T t, Session session)throws Exception;
    T save(T t, Session session)throws Exception;
    List<T> getAll(Session session)throws Exception;

}
