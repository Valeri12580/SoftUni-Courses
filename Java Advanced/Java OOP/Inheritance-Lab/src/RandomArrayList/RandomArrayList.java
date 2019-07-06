package RandomArrayList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement(){
        Random random=new Random();
        Object value=super.remove(random.nextInt(super.size()));
        return value ;
    }
}
