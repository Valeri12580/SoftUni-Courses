package pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstInputLine=reader.readLine().split(" ");
            String name=firstInputLine[1];
            int numberOfToppings= Integer.parseInt(firstInputLine[2]);

            Pizza pizza=new Pizza(name,numberOfToppings);

            String[] secondInputLine=reader.readLine().split(" ");

            String flourType=secondInputLine[1];
            String bakingTechnique=secondInputLine[2];
            double grams= Double.parseDouble(secondInputLine[3]);

            Dough dough=new Dough(flourType,bakingTechnique,grams);
            pizza.setDough(dough);

            String[]inputs=reader.readLine().split(" ");

            while (!inputs[0].equals("END")){
                String toppingType=inputs[1];
                double weightTopping= Double.parseDouble(inputs[2]);
                Topping topping=new Topping(toppingType,weightTopping);

                pizza.addToppings(topping);



                inputs=reader.readLine().split(" ");
            }

            System.out.println(pizza.getName()+" - " +pizza.getOverallCalories());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());

        }



    }
}
