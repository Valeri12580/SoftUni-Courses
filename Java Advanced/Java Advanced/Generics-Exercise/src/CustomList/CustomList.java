package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList <T extends  Comparable<T>> {
  private List<T> data;

    public T getData(int index) {
        return this.data.get(index);
    }

    public CustomList() {
        this.data=new ArrayList<>();

    }
    public int size(){
        return  this.data.size();
    }

    public void add(T element){
        data.add(element);
    }
    public T remove(int index){
        return data.remove(index);
    }

    public boolean contains(T element){
       return data.contains(element);
    }

    public void swap(int firstIndex,int secondIndex){
        Collections.swap(this.data,firstIndex,secondIndex);
    }

    public int countGreaterThan(T element){
        return  (int)this.data.stream().filter(e-> e.compareTo(element)>0).count();
    }
    public T getMax(){
        return Collections.max(this.data);
    }
    public T getMin(){
        return Collections.min(this.data);
    }

    public void print(){
        data.forEach(System.out::println);
    }


}
