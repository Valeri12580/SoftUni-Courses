package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class MissionImpl implements  Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {


        ArrayList<String> planetItems = new ArrayList<>(planet.getItems());

        for (Astronaut astronaut : astronauts) {
            while (! planet.getItems().isEmpty() && astronaut.canBreath() ){
                String item=planetItems.remove(0);
                planet.getItems() .remove(item);
                astronaut.getBag().getItems().add(item);
                astronaut.breath();
            }

        }

    }
}
