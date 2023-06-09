package lk.ijse.hostelmanagementsystem.util;

import lk.ijse.hostelmanagementsystem.entity.custom.Room;
import lk.ijse.hostelmanagementsystem.entity.custom.RoomType;
import lk.ijse.hostelmanagementsystem.entity.custom.Student;
import lk.ijse.hostelmanagementsystem.entity.custom.StudentRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration faactoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration=
        new Configuration().configure()
                .addAnnotatedClass(RoomType.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentRoom.class);
        sessionFactory=configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance(){
        if(faactoryConfiguration==null)
            faactoryConfiguration=new FactoryConfiguration();
        return faactoryConfiguration;

    }
    public Session getSession(){
        return sessionFactory.openSession();
    }

}
