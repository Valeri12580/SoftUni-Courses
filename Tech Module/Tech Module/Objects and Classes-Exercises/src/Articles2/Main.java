package Articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Articles2> storage=new ArrayList<>();

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n; i++) {

            String[]input=scanner.nextLine().split(", ");

            Articles2 article=new Articles2(input[0],input[1],input[2]);

            storage.add(article);

        }
        String lastInput=scanner.nextLine();

        switch (lastInput){
            case "title":
                    storage.stream().sorted((p1,p2)->p1.getTitle().compareTo(p2.getTitle())).forEach(e-> System.out.println(e.toString()));
                break;

            case "content":
                storage.stream().sorted((p1,p2)->p1.getContent().compareTo(p2.getContent())).forEach(e-> System.out.println(e.toString()));
                break;


            case "author":
                storage.stream().sorted((p1,p2)->p1.getAuthor().compareTo(p2.getAuthor())).forEach(e-> System.out.println(e.toString()));
                break;
        }



    }
}
