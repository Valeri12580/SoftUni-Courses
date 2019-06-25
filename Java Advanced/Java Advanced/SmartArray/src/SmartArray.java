import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY= 4;

    private int[]data;
    private int size;
    private int capasicy;

    public SmartArray() {
        this.data=new int[INITIAL_CAPACITY];
        this.capasicy=INITIAL_CAPACITY;



    }

    public void add(int element){
        if(this.size==this.capasicy){
           this.capasicy*=2;
            int[]tempArray=new int[this.capasicy];
            for (int i = 0; i <data.length; i++) {
                tempArray[i]=data[i];
            }
            this.data=tempArray;
            this.data[size++]=element;

        }else{
            this.data[size++]=element;
        }


    }

    public int get(int index){
        return this.data[index];
    }

    public boolean contains(int element){
        for (int i = 0; i <this.size; i++) {
            if(data[i]==element){
                return true;

            }
        }
        return false;
    }
    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(i);
        }
    }


    public void remove(int index){

        int[]tempArray=new int[--size];

        for (int i = 0; i <index ; i++) {
            tempArray[i]=data[i];

        }
        int count=index;
        for (int i = index+1; i <=size; i++) {

                tempArray[count]=data[i];
                count++;



        }
        data=tempArray;




    }
}
