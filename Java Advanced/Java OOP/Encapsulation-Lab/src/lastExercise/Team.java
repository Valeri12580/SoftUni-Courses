package lastExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person>firstTeam;
    private List<Person>reserveTeam;

    public Team(String name) {
        setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam=new ArrayList<>();
    }

    private void setName(String name) {
        this.name=name;
    }

    public void addPerson(Person person){
        if(person.getAge()<40){
            firstTeam.add(person);
        }else{
            reserveTeam.add(person);
        }
    }

    public List<Person>getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person>getReservedTeamTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }


}
