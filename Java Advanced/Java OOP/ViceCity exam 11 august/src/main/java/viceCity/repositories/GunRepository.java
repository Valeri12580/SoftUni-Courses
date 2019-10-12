package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun>models;

    public GunRepository() {
        this.models = new LinkedHashSet<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
       models.add(model);



    }

    @Override
    public boolean remove(Gun model) {

        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        Gun gun=null;
        for (Gun model : models) {
            if(model.getName().equals("name")){
                gun=model;
                break;
            }
        }
        return gun;

    }
}
