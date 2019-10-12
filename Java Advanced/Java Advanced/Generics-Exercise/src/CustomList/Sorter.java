package CustomList;

import java.util.Collections;

public class Sorter  {
    public static<T extends Comparable<T>> void  sortirane(CustomList<T>list){
        for (int i = 0; i <list.size()  -1; i++) {
            for (int j = i+1; j <list.size() ; j++) {
                if(list.getData(i).compareTo(list.getData(j))>0){
                    list.swap(i,j);
                }


            }
        }
    }
}
