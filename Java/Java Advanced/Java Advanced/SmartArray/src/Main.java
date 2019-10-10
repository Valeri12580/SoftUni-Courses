public class Main {
    public static void main(String[] args) {
        SmartArray array=new SmartArray();

        array.add(523);
        array.add(51);
        array.add(12321);
        array.add(4);
        array.add(18);
        array.add(22);
        array.add(35);
        System.out.println(array.get(2));
        System.out.println(array.contains(12321));

        array.forEach(e-> System.out.println("Pishka"));
        array.remove(2);
        System.out.println(array.get(2));
        System.out.println();


    }
}
