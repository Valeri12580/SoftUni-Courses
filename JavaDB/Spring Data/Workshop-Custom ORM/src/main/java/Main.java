import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {

        Connector.createConnection("root","1234","orm_db");

        EntityManager<User> entityManager=new EntityManager<>(Connector.getConnection());

        User user=new User("Valeri","1234",15,new Date());
       entityManager.persist(user);

    }
}
