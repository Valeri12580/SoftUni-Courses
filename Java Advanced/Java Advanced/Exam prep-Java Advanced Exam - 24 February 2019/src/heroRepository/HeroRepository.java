package heroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HeroRepository {
    private List<Hero>data;

    public HeroRepository(){
        this.data=new ArrayList<>();
    }
    public void remove(String name){
        Hero hero=null;
        for (int i = 0; i < this.data.size(); i++) {
            hero=this.data.get(i);
            if(hero.getName().equals(name)){
                this.data.remove(i);
                break;
            }

        }
    }

    public void add (Hero hero){
        data.add(hero);
    }

    public List<Hero> getData() {
        return data;
    }



    public Hero getHeroWithHighestStrength(){
        return this.data.stream().sorted((p1,p2)->Integer.compare(p2.getItem().getStrength(),p1.getItem().getStrength())).collect(Collectors.toList()).get(0);

    }
    public Hero getHeroWithHighestAgility(){
        return this.data.stream().sorted((p1,p2)->Integer.compare(p2.getItem().getAgility(),p1.getItem().getAgility())).collect(Collectors.toList()).get(0);

    }
    public Hero getHeroWithHighestIntelligence(){
        return this.data.stream().sorted((p1,p2)->Integer.compare(p2.getItem().getIntelligence(),p1.getItem().getIntelligence())).collect(Collectors.toList()).get(0);

    }
    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
       StringBuilder sb=new StringBuilder();
        for (Hero hero : data) {
            sb.append(hero+System.lineSeparator());

        }
        return sb.toString();
    }
}
