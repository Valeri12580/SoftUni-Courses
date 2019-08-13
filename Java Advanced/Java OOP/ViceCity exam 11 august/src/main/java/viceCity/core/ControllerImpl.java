package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Repository<Gun> gunRepository;
    private Collection<Player>  civilPlayers;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.gunRepository = new GunRepository();
        civilPlayers=new ArrayList<>();

    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer=new CivilPlayer(name);
        civilPlayers.add(civilPlayer);
        return String.format("Successfully added civil player: %s",name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun=null;
        if(!type.equals("Pistol")&&!type.equals("Rifle")){
           return "Invalid gun type!" ;
        }else{

            if(type.equals("Pistol")){
                gun=new Pistol(name);
            }else{
                gun=new Rifle(name);
            }
        }
        gunRepository.add(gun);

        return String.format("Successfully added %s of type: %s",name,type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if(gunRepository.getModels().isEmpty()){
            return "There are no guns in the queue!";
        }
        List<Gun>list=new ArrayList<>(gunRepository.getModels());
        Gun gun=list.remove(0);
        if(name.equals("Vercetti")){

            this.mainPlayer.getGunRepository().add(gun);
            gunRepository.remove(gun);
            return String.format("Successfully added %s to the Main Player: Tommy Vercetti",gun.getName());
        }

        for (Player civilPlayer : civilPlayers) {
            if(civilPlayer.getName().equals(name)){
                civilPlayer.getGunRepository().add(gun);
                gunRepository.remove(gun);
                return String.format("Successfully added %s to the Civil Player: %s",gun.getName(),civilPlayer.getName());
            }
        }
       return "Civil player with that name doesn't exists!";
    }

    @Override
    public String fight() {
        GangNeighbourhood gang=new GangNeighbourhood();
        int beforeFightNumbersOfCivil=civilPlayers.size();
        gang.action(mainPlayer,civilPlayers);
        if(mainPlayer.getLifePoints()!=100){
            return String.format("A fight happened:\n" +
                    "Tommy live points: %s!\"\n" +
                    "Tommy has killed: %d players!\n" +
                    "Left Civil Players: %s!\n",mainPlayer.getLifePoints(),civilPlayers.size()-beforeFightNumbersOfCivil,civilPlayers.size());
        }

        return "Everything is okay!";
    }
}
