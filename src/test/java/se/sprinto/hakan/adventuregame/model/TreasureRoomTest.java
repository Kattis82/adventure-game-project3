package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class TreasureRoomTest {

    @Test
    @DisplayName("Kontrollerar att kistan bara går att öppna om man har nyckel")
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

        // act

        treasureRoom.enterRoom(player,fakeUI);

        // assert
        Assertions.assertTrue(player.hasOpenedChest());
    }


    @Test
    @DisplayName("Kontrollerar att kistan inte går att öppna utan nyckel")
    void testNoKeyNotOpenChest() {

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

        // act

        treasureRoom.enterRoom(player,fakeUI);

        // assert
        Assertions.assertFalse(player.hasOpenedChest());
    }

}