package StackIterator;

public class Main {
    public static void main(String[] args) {
        StackIterator stack=new StackIterator();


        stack.push(12);
        stack.push(43);
        stack.push(123);


        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
