package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class TreasureRoomTest {

    @Test
    @DisplayName("Kontroll - kistan går bara att öppna om man har nyckel")
    void testKeyCanOpenChest() {

        // arrange
        TreasureRoom treasureRoom = new TreasureRoom();

        Player player = new Player.Builder()
                .name("Oscar")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();

        // spelaren måste ha nyckel innan man testar att öppna kistan
        player.setFoundKey(true);
        fakeUI.setInput("ja");

        // act - kör metoden enterRoom
        treasureRoom.enterRoom(player,fakeUI);

        // assert - kollar att kistan är öppnad
        Assertions.assertTrue(player.hasOpenedChest());
    }


    @Test
    @DisplayName("Kontroll -kistan går inte att öppna utan nyckel")
    void testNotOpenChestWithoutKey() {

        // arrange
        TreasureRoom treasureRoom = new TreasureRoom();

        Player player = new Player.Builder()
                .name("Oscar")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();

        // spelaren måste ha nyckel innan man testar att öppna kistan
        // nyckel saknas här
        fakeUI.setInput("ja");

        // act - kör metoden enterRoom
        treasureRoom.enterRoom(player,fakeUI);

        // assert - kollar att det inte går att öppna kistan
        Assertions.assertFalse(player.hasOpenedChest());
    }

}