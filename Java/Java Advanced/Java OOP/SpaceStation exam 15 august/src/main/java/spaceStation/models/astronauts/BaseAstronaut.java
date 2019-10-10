package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException("Astronaut name cannot be null or empty.");
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if(oxygen<0){
            throw  new IllegalArgumentException("Cannot create Astronaut with negative oxygen!");
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen>0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if(this instanceof Biologist){
            this.oxygen-=5;
        }else{
            this.oxygen-=10;
        }

        if(this.oxygen<0){
            this.oxygen=0;
        }

    }
}
