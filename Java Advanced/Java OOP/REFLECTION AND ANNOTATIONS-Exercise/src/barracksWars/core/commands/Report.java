package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }
    private String reportCommand(String[] data) {
        String output = this.getRepository().getStatistics();
        return output;
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}