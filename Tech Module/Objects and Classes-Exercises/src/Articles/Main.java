package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]input=scanner.nextLine().split(", ");
        Articles article=new Articles(input[0],input[1],input[2]);

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n; i++) {

            String[]command=scanner.nextLine().split(": ");
            String firstCommand=command[0];
            String secondCommand=command[1];

            switch (firstCommand){
                case "Edit":
                    article.edit(secondCommand);


                    break;
                case "ChangeAuthor":
                    article.changeAuthor(secondCommand);

                    break;

                case "Rename":
                        article.rename(secondCommand);
                    break;


            }




        }
        System.out.println(article);
    }


}
