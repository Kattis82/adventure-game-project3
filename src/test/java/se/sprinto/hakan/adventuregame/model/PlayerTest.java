package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Kontrollera att fiendens hälsa minskar med spelarens styrka")
    void testEnemyHealthAfterAttack() {

        // arrange

        Player player = new Player.Builder()
                .name("Soya")
                .health(120)
                .score(0)
                .strength(10)
                .build();

        Enemy enemy = new Enemy("Ork",30,0,5);

        // act

        int healthBefore = enemy.getHealth();
        player.attack(enemy);

        // fiendens hälsa innan attacken minus hälsan efter attacken
        int result = healthBefore - enemy.getHealth();

        // assert - fiendens hälsa innan attack (30) - hälsan efter attack  = 10

        Assertions.assertEquals(10,result);


    }
}