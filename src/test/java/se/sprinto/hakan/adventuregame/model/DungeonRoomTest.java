package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class DungeonRoomTest {

    @Test
    @DisplayName("Kontrollerar att spelaren besegras fienden genom att välja a")
    public void testAttackDefeatsEnemy() {

        // arrange
        DungeonRoom dungeonRoom = new DungeonRoom();

        Player player = new Player.Builder()
                .name("Soya")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        // act

        dungeonRoom.enterRoom(player,fakeUI);

        // välj (a)för att attackera
        fakeUI.setInput("a");

        // assert

        Assertions.assertTrue(player.hasDefeatedEnemy());
    }
}
