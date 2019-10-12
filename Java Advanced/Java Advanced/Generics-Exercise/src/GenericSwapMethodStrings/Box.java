package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box <E> extends ArrayList<E> {
    private E data;


    public Box(E data){
        this.data=data;
    }

    @Override
    public String toString() {
        return String.class.getName()+": "+data;
    }
}
