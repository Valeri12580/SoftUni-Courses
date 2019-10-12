package viceCity.models.guns;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
       setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw  new NullPointerException("Name cannot be null or whitespace!");
        }
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if(bulletsPerBarrel<0){
            throw  new IllegalArgumentException("Bullets cannot be below zero!");
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        if(totalBullets<0){
            throw  new IllegalArgumentException("Total bullets cannot be below zero!");
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.bulletsPerBarrel>0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }


}
