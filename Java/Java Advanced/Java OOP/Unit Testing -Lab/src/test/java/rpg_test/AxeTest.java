package rpg_test;

import org.junit.Assert;
import org.junit.Test;
import rpg_Lab.Axe;
import rpg_Lab.Dummy;
import rpg_Lab.Hero;

public class AxeTest {
    @Test()
    public void doesWeaponLostDurabilityAfterAttack(){
        Hero hero = new Hero("Valeri");
        Dummy dm=new Dummy(10,10);


        hero.attack(dm);

        Assert.assertEquals(9,hero.getWeapon().getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)

   public void testAttackWithBrokenWeapon(){
        Axe axe=new Axe(300,0);

        axe.attack(new Dummy(10,10));
    }
}
