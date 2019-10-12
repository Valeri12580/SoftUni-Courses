package rpg_test;

import org.junit.Assert;
import org.junit.Test;
import rpg_Lab.Axe;
import rpg_Lab.Dummy;
import rpg_Lab.Hero;

public class DummyTest {
    @Test
    public void testDummyLoseHealth(){
        Dummy dummy=new Dummy(100,100);
        Axe axe=new Axe(50,100);
        axe.attack(dummy);
        Assert.assertEquals(50,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyThrowsExceptionIfAttackedDead(){

        Dummy dummy=new Dummy(0,300);
        Axe axe=new Axe(100,100);


        axe.attack(dummy);

    }
    @Test
    public void testDummyGivesExperienceIfDead(){
        Dummy dm=new Dummy(1,100);
        Hero hero=new Hero("Valeri");
        hero.attack(dm);

        Assert.assertEquals(100,hero.getExperience());

    }
    @Test
    public void testDummyGivesExperienceIfAlive(){
        Dummy dm=new Dummy(100,100);
        Hero hero=new Hero("Valeri");
        hero.attack(dm);

        Assert.assertEquals(0,hero.getExperience());

    }
}
