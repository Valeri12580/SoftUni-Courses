package shapes;

public class Main {
    public static void main(String[] args) {

        Shape circle=new Circle((double) 5);
        circle.calculateArea();

        System.out.println(circle.getArea());
    }
}
