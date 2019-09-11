package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetImpl implements Planet {
    private String name;
    private Collection<String>items;

    public PlanetImpl(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw  new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
