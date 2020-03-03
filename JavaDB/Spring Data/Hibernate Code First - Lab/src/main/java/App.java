import entity.abst.BasicIngredient;
import entity.abst.BasicLabel;
import entity.abst.BasicShampoo;
import entity.classes.Mint;
import entity.classes.PinkPanther;
import entity.classes.Strawberry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class App {
    public static void main(String[] args) {

            EntityManagerFactory emf=Persistence.createEntityManagerFactory("code_first");
            EntityManager manager=emf.createEntityManager();

            manager.getTransaction().begin();

        BasicIngredient mint=new Mint();
        BasicIngredient strawberry=new Strawberry();

        BasicLabel label=new BasicLabel("Mirizma na laina","ot Valeri");

        BasicShampoo shampoo=new PinkPanther(label);

        shampoo.getIngredients().add(strawberry);
        shampoo.getIngredients().add(mint);

        manager.persist(shampoo);








            manager.getTransaction().commit();



    }
}
