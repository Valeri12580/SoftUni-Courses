import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberTabs=Integer.parseInt(scanner.nextLine());
        int salary=Integer.parseInt(scanner.nextLine());

        int facebook=150;
        int instagram=100;
        int reddit=50;
        for (int i=0;i <numberTabs;i++) {
            String site=scanner.nextLine();
            switch (site){
                case "Facebook":
                    salary-=facebook;
                    break;
                case "Instagram":
                    salary-=instagram;
                    break;
                case "Reddit":
                    salary-=reddit;
            }

            if(salary<=0){
                System.out.println("You have lost your salary.");
                return;
            }


        }
        System.out.println(salary);


    }

}
