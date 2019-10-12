package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract  class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private Repository<Gun>repository;

    protected BasePlayer(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
        repository=new GunRepository();

    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw  new NullPointerException("Player's name cannot be null or a whitespace!");
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if(lifePoints<0){
            throw  new IllegalArgumentException("Player life points cannot be below zero!");
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints>0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.repository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints-=points;
        if(this.lifePoints<0){
            this.lifePoints=0;
        }
    }
}
