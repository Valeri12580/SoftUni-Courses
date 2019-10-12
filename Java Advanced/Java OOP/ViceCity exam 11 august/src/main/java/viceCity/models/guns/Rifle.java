package viceCity.models.guns;

public class Rifle extends BaseGun {

    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        if(!this.canFire()){
            this.setTotalBullets(this.getTotalBullets()-50);
            this.setBulletsPerBarrel(50);
        }

        this.setBulletsPerBarrel(this.getBulletsPerBarrel()-5);

        return 5;
    }
}
