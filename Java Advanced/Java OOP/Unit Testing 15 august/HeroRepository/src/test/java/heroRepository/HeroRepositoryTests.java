package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    HeroRepository repository;


    @Before
    public void createRepository() {
        repository = new HeroRepository();
    }

    @Test
    public void getCountShouldReturnProperValue() {
        repository.create(new Hero("Valeri", 60));
        repository.create(new Hero("Petur", 1));
        Assert.assertEquals(2, repository.getCount());
    }


    @Test(expected = NullPointerException.class)
    public void createShouldThrowExceptionIfHeroIsNull() {
        repository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldThrowExceptionIfThereAreDuplicates(){
       repository.create(new Hero("Valeri", 60));
       repository.create(new Hero("Valeri", 60));
    }
    @Test
    public void createShouldAddHeroToRepository(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);

        Assert.assertEquals(1,repository.getCount());
        Assert.assertEquals(power,repository.getHero("Valeri"));
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenNullNameHeroIsGiven(){
        repository.remove(null);

    }
    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenEmptyNameHeroIsGiven(){
        repository.remove("");

    }

    @Test
    public void removeShouldReturnTrueWhenObjectIsSuccessfulRemoved(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        Assert.assertTrue(repository.remove("Valeri"));
    }
    @Test
    public void removeShouldReturnFalseWhenObjectIsSuccessfulRemoved(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        Assert.assertFalse(repository.remove("Ivan"));
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnHighestLevel(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        repository.create(new Hero("Petur", 1));

        Assert.assertEquals(power,repository.getHeroWithHighestLevel());

    }
    @Test
    public void getHeroShouldReturnTheCorrectHero(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        repository.create(new Hero("Petur", 1));
        Assert.assertEquals("Petur",repository.getHero("Petur").getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getHeroesShouldThrowExceptionIfThereIsATryToModifyTheCollection(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        repository.create(new Hero("Petur", 1));
        repository.getHeroes().add(new Hero("Nikolai",60));
    }
    @Test
    public void getHeroesShouldReturnAllHeroes(){
        Hero power=new Hero("Valeri", 60);
        repository.create(power);
        repository.create(new Hero("Petur", 1));
        Assert.assertEquals(2,repository.getHeroes().size());
    }


}
