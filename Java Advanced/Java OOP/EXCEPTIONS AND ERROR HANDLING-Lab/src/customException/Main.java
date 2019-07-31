package customException;

public class Main {
    public static void main(String[] args) {

        try {
            Student student=new Student("Pesho4","dasd@abv.bg");
        }catch (InvalidPersonNameException ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("From finally");
        }

        System.out.println("After try-catch");

    }
}
