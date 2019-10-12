package viceCity.models.guns;

public class Pistol extends BaseGun {


    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        //shoot only one bullet
        if(!this.canFire()){
            this.setTotalBullets(this.getTotalBullets()-10);
            this.setBulletsPerBarrel(10);
        }

        this.setBulletsPerBarrel(this.getBulletsPerBarrel()-1);

        return 1;
    }
}
