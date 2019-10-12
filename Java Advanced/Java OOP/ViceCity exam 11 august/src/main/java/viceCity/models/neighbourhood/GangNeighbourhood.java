package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        List<Gun>mainPlayerGuns=mainPlayer.getGunRepository().getModels().stream().collect(Collectors.toList());

        List<Player>civilPlayersList=new ArrayList<>(civilPlayers);

        Gun currentGun=mainPlayerGuns.remove(0);
        Player currentCivilPlayer=civilPlayersList.remove(0);



        while (mainPlayerGuns.size()!=0 || civilPlayersList.size()!=0){
            if(currentGun.getTotalBullets()==0){
                mainPlayer.getGunRepository().remove(currentGun);
                currentGun=mainPlayerGuns.remove(0);
            }

           currentCivilPlayer.takeLifePoints(currentGun.fire());


            if(!currentCivilPlayer.isAlive()){
                civilPlayers.remove(currentCivilPlayer);
                currentCivilPlayer=civilPlayersList.get(0);

            }



        }
        mainPlayerGuns.add(currentGun);

        List<Gun>civilPlayerGuns=new ArrayList<>(currentCivilPlayer.getGunRepository().getModels());
        currentGun=civilPlayerGuns.remove(0);

        while (civilPlayersList.size()!=0 || mainPlayer.isAlive()){
            if(civilPlayerGuns.isEmpty()){
                currentCivilPlayer=civilPlayersList.remove(0);
            }
            if(currentGun.getTotalBullets()==0){
                currentGun=civilPlayerGuns.remove(0);
            }

            mainPlayer.takeLifePoints(currentGun.fire());

        }






    }
}
