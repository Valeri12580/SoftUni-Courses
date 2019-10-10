package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    public void retire(String unitType) throws ExecutionControl.NotImplementedException {


    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
       return this.getRepository().removeUnit(getData()[1]);
    }
}
