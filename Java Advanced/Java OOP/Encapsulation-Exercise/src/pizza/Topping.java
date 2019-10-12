package pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        Validator.validateTopping(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(this.toppingType,weight);
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories=this.weight*2;

        if(this.toppingType.equals("Meat")){
            calories*=1.2;
        }else if (this.toppingType.equals("Veggies")){
            calories*=0.8;
        }else if (this.toppingType.equals("Cheese")){
            calories*=1.1;
        }else{
            calories*=0.9;
        }
        return calories;
    }


}
