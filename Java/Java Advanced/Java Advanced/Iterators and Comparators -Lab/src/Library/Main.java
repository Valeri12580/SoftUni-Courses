package Library;

public class Main {
    public static void main(String[] args) {
        Book one =new Book("Jiniid",2019,"ebacha");
        Book two=new Book("Ebachi",2039,"glaven Ebach","ebaniq");

        Library library=new Library(one,two);
        for (Book book : library) {
            System.out.println(book.getTitle());
        }




    }
}
