package models.players.interfaces;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.DEFAULT_REPORT_SEPARATOR;
import static common.ConstantMessages.PLAYER_REPORT_INFO;

public  abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private  boolean isDead;


    protected BasePlayer( CardRepository cardRepository,String username, int health) {
        this.cardRepository = cardRepository;
        setUsername(username);
        setHealth(health);
        setDead();
    }

    private void setUsername(String username) {
        if(username == null||username.trim().isEmpty() ){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }
    @Override
    public void setHealth(int health) {
        if(health<0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health = health;
    }

    public void addCard(Card card) {
        this.cardRepository.add(card);
    }

    private void setDead() {
        isDead = false;
    }


    public void  takeDamage(int damagePoints){
        if(damagePoints<0){
            throw  new IllegalArgumentException("Damage points cannot be less than zero.");
        }
       this.health-=damagePoints;
        if(this.health<=0){
            this.health=0;
            isDead=true;
        }

    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }
    @Override
    public String toString() {
        int cardCount = this.cardRepository.getCount();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PLAYER_REPORT_INFO, this.getUsername(), this.getHealth(), cardCount))
                .append(System.lineSeparator());
        this.getCardRepository()
                .getCards()
                .forEach(c -> sb.append(c.toString())
                        .append(System.lineSeparator()));
        sb.append(DEFAULT_REPORT_SEPARATOR);

        return sb.toString().trim();
    }
}

