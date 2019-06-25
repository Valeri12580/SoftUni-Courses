package GenericSwapMethodsIntegers;

import java.util.ArrayList;

public class Box <E> extends ArrayList<E> {
    private E data;


    public Box(E data){
        this.data=data;
    }

    @Override
    public String toString() {
        return Integer.class.getName()+": "+data;
    }
}
