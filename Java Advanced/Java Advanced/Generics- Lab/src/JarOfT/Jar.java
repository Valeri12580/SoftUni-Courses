package JarOfT;

import java.util.ArrayList;
import java.util.List;

public class Jar<E> {
    private List<E> data;



    public Jar() {
        this.data=new ArrayList<>();
    }



    public void add(E element){
        this.data.add(element);

    }
    public E  remove(){
        return this.data.remove(data.size()-1);
    }
}
