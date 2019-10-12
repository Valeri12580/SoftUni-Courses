package validPerson;

public class Main {
    public static void main(String[] args) {
        try {
            Person valeri=new Person(null,"Stoqnov",-2);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }catch (NullPointerException nex){
            System.out.println(nex.getMessage());
        }

    }
}
