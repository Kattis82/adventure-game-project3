package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class ForestRoomTest {

    @Test
    @DisplayName("Kontrollera att spelaren hittar nyckeln om svaret är ja")
    public void testFindKeyIfYes() {

        // arrange - variabler och objekt som behövs

        ForestRoom forestRoom = new ForestRoom();

        Player player = new Player.Builder()
                .name("Kattis")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();

        // Vill undersöka glittret
        fakeUI.setInput("ja");

        // act - kör metoden
        forestRoom.enterRoom(player,fakeUI);

        // assert - kollar att användaren hittade nyckeln
        Assertions.assertTrue(player.hasFoundKey());

    }
}
