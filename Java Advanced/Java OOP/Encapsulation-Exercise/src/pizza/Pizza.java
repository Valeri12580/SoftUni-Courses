package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping>toppings;
    private int numberOfToppings;

    public Pizza(String name,int numberOfToppings){
        setName(name);
        setToppings(numberOfToppings);
        this.toppings=new ArrayList<>(this.numberOfToppings);

    }

    public void setToppings(int numberOfToppings) {
        Validator.validateToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }



    public void setDough(Dough dought) {
        this.dough = dought;
    }

    public String getName() {
        return name;
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories(){

        return dough.calculateCalories()+toppings.stream().mapToDouble(Topping::calculateCalories).sum(); //vrushta dough i topping;
    }
}
