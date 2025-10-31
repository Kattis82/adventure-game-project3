package se.sprinto.hakan.adventuregame.model;

public class Wizard extends AbstractCharacter {

    public Wizard(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (target.isAlive() && target.getStrength() > 6) {
            target.removeStrength(5);
        }

    }
}
