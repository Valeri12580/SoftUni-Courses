package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if(attackPlayer.isDead() || enemyPlayer.isDead()){
            throw  new IllegalArgumentException("Player is dead!");

        }
        if(attackPlayer instanceof Beginner) {
            attackPlayer.setHealth(attackPlayer.getHealth() + 40);
            attackPlayer.getCardRepository().getCards().forEach(e->e.setDamagePoints(e.getDamagePoints()+30));

        }
        if(enemyPlayer instanceof Beginner) {
            enemyPlayer.setHealth(attackPlayer.getHealth() + 40);
            enemyPlayer.getCardRepository().getCards().forEach(e->e.setDamagePoints(e.getDamagePoints()+30));

        }
        getHealthPointsFromDeck(attackPlayer);
        getHealthPointsFromDeck(enemyPlayer);

        processFight(attackPlayer,enemyPlayer);


    }

    private void processFight(Player attackPlayer, Player enemyPlayer) {
        while (true){
            enemyPlayer.takeDamage(attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum());
            if(enemyPlayer.isDead()){
                return;
            }
            attackPlayer.takeDamage(enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum());
            if(attackPlayer.isDead()){
                return;
            }
        }

    }

    private void getHealthPointsFromDeck(Player attackPlayer) {
      int healthPoints=attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
      attackPlayer.setHealth(attackPlayer.getHealth()+healthPoints);
    }
}
