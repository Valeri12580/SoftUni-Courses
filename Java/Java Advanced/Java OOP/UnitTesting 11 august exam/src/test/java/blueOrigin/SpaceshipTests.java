package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    @Test
    public void testConstructor(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("Valeri",12318));
        Assert.assertEquals("Klsira",spaceship.getName());

    }

    @Test
    public  void testIfGetCountAustronautsWork(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("Valeri",12318));
        Assert.assertEquals(1,spaceship.getCount());
    }
    @Test
    public  void testIfGetCapacityAustronautsWork(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("Valeri",12318));
        Assert.assertEquals(2,spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfThrownExceptionIfThereIsNoCapacityWhenAdding(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("dasd",12318));
        spaceship.add(new Astronaut("Valeri",12318));
        spaceship.add(new Astronaut("Vasadleri",12318));
    }
    @Test
    public void testIfGetNameIsCorrect(){
        Spaceship spaceship=new Spaceship("Klsira",2);

        Assert.assertEquals("Klsira",spaceship.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfThrowingExceptionWhenAstronautIsContainedOperationAdd(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("dasd",12318));
        spaceship.add(new Astronaut("dasd",12318));
    }
    @Test
    public void ShouldRemoveIfContainsWorkCorrectAndReturnTrue(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("dasd",12318));

        Assert.assertTrue(spaceship.remove("dasd"));
    }
    @Test
    public void ShouldNotRemoveAndReturnFalse(){
        Spaceship spaceship=new Spaceship("Klsira",2);
        spaceship.add(new Astronaut("dasd",12318));

        Assert.assertFalse(spaceship.remove("dasdda"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void invalidCapacityShouldThrowExceptin(){
        Spaceship spaceship=new Spaceship("Klsira",-1);
    }

    @Test(expected = NullPointerException.class)
    public void nameShouldThrowExceptionIfParameterIsNull(){
        Spaceship spaceship=new Spaceship(null,2);
    }
    @Test(expected = NullPointerException.class)
    public void nameShouldThrowExceptionIfParameterIsEmpty(){
        Spaceship spaceship=new Spaceship(null,2);
    }

}
