package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.EngineImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.BasePlayer;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        ControllerImpl imp=new ControllerImpl();
//        Player mainPlayer=new MainPlayer();
//        Player civilPlayer1=new CivilPlayer("Valeri");
//        Player civilPlayer2=new CivilPlayer("Ivansa");
//
        System.out.println(imp.addPlayer("Valeri"));
//        System.out.println(imp.addPlayer("Ivansa"));
        System.out.println(imp.addGun("Rifdsadle", "Killer"));
        System.out.println(imp.addGun("Rifle", "kalak"));
        System.out.println(imp.addGun("Pistol", "usp"));

        System.out.println(imp.addGunToPlayer("Vercetti"));
        System.out.println(imp.addGunToPlayer("Valeri"));
        System.out.println(imp.addGunToPlayer("Valeri"));


        System.out.println();

        Engine engine=new EngineImpl(imp);
        engine.run();

    }
}
