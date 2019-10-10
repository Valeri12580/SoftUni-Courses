package VehicleCatalogue;

public class blabla {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public blabla(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public blabla(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n" +
                "Model: %s\n" +
                "Color: %s\n" +
                "Horsepower: %d",getType(),getModel(),getColor(),getHorsepower());
    }
}
