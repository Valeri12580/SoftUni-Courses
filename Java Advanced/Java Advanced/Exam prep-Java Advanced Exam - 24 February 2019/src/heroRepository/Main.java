package heroRepository;

public class Main {
    public static void main(String[] args) {
        Item item=new Item(15,100,120);

        Hero hero=new Hero("Valeri",18,item);

        HeroRepository repository=new HeroRepository();
        repository.add(hero);



        Item item2=new Item(335,1,213213);

        Hero hero2=new Hero("Svetlin",100,item2);
        repository.add(hero2);

        System.out.println(repository.getHeroWithHighestAgility());


        System.out.println();


        System.out.println(repository);

    }
}
