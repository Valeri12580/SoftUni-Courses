package Scale;

public class Scale<T extends  Comparable<T>> {
    private T firstElement;
    private T secondElement;

    public Scale(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;

    }

    public T getHeavier(){
        if(this.firstElement.compareTo(this.secondElement)==0){
            return null;
        }else if (firstElement.compareTo(secondElement)>0){
            return firstElement;
        }else{
            return secondElement;
        }

    }




}
