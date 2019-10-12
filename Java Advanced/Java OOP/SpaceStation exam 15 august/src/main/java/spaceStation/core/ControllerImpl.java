package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        mission=new MissionImpl();
        exploredPlanets=0;

    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut=new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException("Astronaut type doesn't exists!");
        }
        astronautRepository.add(astronaut);
        return String.format("Successfully added %s: %s!",type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String[]items) {
        Planet planet=new PlanetImpl(planetName);
        Arrays.stream(items).forEach(e->planet.getItems().add(e));
        planetRepository.add(planet);
        return String.format("Successfully added Planet: %s!",planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut=astronautRepository.getModels().stream().filter(e->e.getName().equals(astronautName)).limit(1).findFirst().orElse(null);
        if(astronaut==null){
            throw  new IllegalArgumentException(String.format("Astronaut %s doesn't exists!",astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format("Astronaut %s was retired!",astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet=this.planetRepository.findByName(planetName);
        Collection<Astronaut>astronauts=astronautRepository.getModels().stream().filter(e->e.getOxygen()>60).collect(Collectors.toList());

        if(astronauts.isEmpty()){
            throw new IllegalArgumentException("You need at least one astronaut to explore the planet!");
        }

        mission.explore(planet,astronauts);

        int countOfDead=0;
        for (Astronaut model : astronauts) {
            if(model.getOxygen()<=0){

                countOfDead++;
            }
        }



        int deadAstronauts=countOfDead;
        exploredPlanets++;
        return String.format("Planet: %s was explored! Exploration finished with %d dead astronauts!",planetName,deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%d planets were explored!%n",exploredPlanets));
        sb.append("Astronauts info:\n");
        for (Astronaut model : astronautRepository.getModels()) {
            sb.append(String.format(
                    "Name: %s%n"+
                    "Oxygen: %.0f%n",model.getName(),model.getOxygen()));
            if(model.getBag().getItems().isEmpty()){
                sb.append("Bag items: none");
                sb.append(System.lineSeparator());
            }else{
                sb.append("Bag items: ");
                sb.append(String.join(", ",model.getBag().getItems()));
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
