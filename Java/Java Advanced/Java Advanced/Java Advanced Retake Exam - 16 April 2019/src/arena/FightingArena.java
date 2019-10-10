package arena;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightingArena {
    private List<Gladiator>data;
    private String name;


    public FightingArena(String name) {
        this.name = name;
        this.data=new ArrayList<>();
    }

    public void add(Gladiator gladiator){
        data.add(gladiator);
    }

    public void remove(String name){
        Gladiator gladiator=null;

        for (int i = 0; i < data.size(); i++) {
           if( this.data.get(i).getName().equals(name)){
               gladiator=this.data.get(i);
           }

        }
        this.data.remove(gladiator);
    }

    public Gladiator getGladiatorWithHighestStatPower(){
        return  this.data.stream().sorted((p1,p2)-> Integer.compare(p2.getStatPower(),p1.getStatPower())).collect(Collectors.toList()).get(0);

    }
    public Gladiator getGladiatorWithHighestWeaponPower(){
        return  this.data.stream().sorted((p1,p2)-> Integer.compare(p2.getWeaponPower(),p1.getWeaponPower())).collect(Collectors.toList()).get(0);

    }
    public Gladiator getGladiatorWithHighestTotalPower(){
        return  this.data.stream().sorted((p1,p2)-> Integer.compare(p2.getTotalPower(),p1.getTotalPower())).collect(Collectors.toList()).get(0);

    }
    public int getCount(){
        return this.data.size();

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s – %d gladiators are participating.",this.getName(),this.getCount());
    }
}
