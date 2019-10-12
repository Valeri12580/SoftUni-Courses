package pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validator.validateFlour(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories =this.weight*2;

        if(this.flourType.equals("White")){
            calories*=1.5;
        }else{
            calories*=1;
        }

        if(bakingTechnique.equals("Crispy")){
            calories*=0.9;
        }else if (this.bakingTechnique.equals("Chewy")){
            calories*=1.1;
        }else{
            calories*=1.0;
        }

        return calories;
    }
}
