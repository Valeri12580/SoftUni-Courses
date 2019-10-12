package ListyIterator;

import java.util.List;

public class ListyIterator {
    List<String> data;
    private int index;


    public ListyIterator(List<String>data){
        this.data=data;
        this.index=0;
    }

    public boolean move(){
        if(this.index<this.data.size()){
            index++;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        return this.index<this.data.size()-1;
    }
    public void Print() throws IllegalAccessException {
        if(data.isEmpty()){

            throw new IllegalAccessException ("Invalid operation!");
        }else{
            System.out.println(this.data.get(this.index));
        }

    }
}
