

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class App {

    private  static final String EXERCISE_ONE="wizards_deposits";
    private  static final String EXERCISE_TWO="sales";
    private  static final String EXERCISE_THREE="university_system";
    private  static final String EXERCISE_FOUR="hospital";
    private  static final String EXERCISE_FIVE="sales";

    public static void main(String[] args) {

        //Когато създаваш  EntityManagerFactory,избери коя задача,искаш от константите по горе
        //също така v persistence.xmml трябва да го промениш на двете места-persistence-unit и
        //съответно на connection url-a
        //в package entities всяка папка е маркирана като excluded-за да тестваш задача първо трябва да я възобновиш
        //--> десен бутон ->Mark directory as ->cancel exclusion
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(EXERCISE_THREE);

       

        Engine engine=new Engine(emf.createEntityManager());
        engine.run();



    }
}
