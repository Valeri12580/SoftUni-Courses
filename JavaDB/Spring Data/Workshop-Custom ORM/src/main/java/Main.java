import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        Connector.createConnection("root","1234","orm_db");

        EntityManager<User> entityManager=new EntityManager<>(Connector.getConnection());


        List<User> users = (List<User>) entityManager.find(User.class);
        for (User user : users) {
            System.out.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getAge()+" "+user.getRegistrationDate());
        }


    }
}
