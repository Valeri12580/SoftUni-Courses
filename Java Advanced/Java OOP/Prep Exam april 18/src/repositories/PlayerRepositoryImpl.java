package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerRepositoryImpl implements PlayerRepository {
    private Map<String,Player>players;

    public PlayerRepositoryImpl() {
        players=new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.players.values().size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players.values().stream().collect(Collectors.toList()));
    }

    @Override
    public void add(Player player) {
        if(player==null){
            throw  new IllegalArgumentException("Player cannot be null");

        }
        if(players.containsKey(player.getUsername())){
            throw  new IllegalArgumentException(String.format("Player %s already exists!",player.getUsername()));
        }

        players.put(player.getUsername(),player);

    }

    @Override
    public boolean remove(Player player) {
        if(player==null){
            throw  new IllegalArgumentException("Player cannot be null!");

        }
        Player removedPlayer=players.remove(player.getUsername());
        boolean isRemoved=true;
        if(removedPlayer==null){
            isRemoved=false;
        }
        return isRemoved;
    }

    @Override
    public Player find(String name) {
        return players.get(name);
    }
}
