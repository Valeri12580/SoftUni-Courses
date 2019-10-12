    import java.util.Scanner;

    public class SpecialNumbers {
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());



            for (int i = 1; i <=n; i++) {
                int number=i;
                int sum=0;
                String i2=""+i;
                for (int j = 0; j <i2.length(); j++) {
                    sum+=number%10;
                    number/=10;
                }


                if(sum==5 || sum==7 || sum==11){
                    System.out.println(String.format("%d -> True",i));
                }else{
                    System.out.println(String.format("%d -> False",i));
                }





            }

        }
    }
