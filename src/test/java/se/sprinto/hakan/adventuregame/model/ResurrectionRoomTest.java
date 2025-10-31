package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class ResurrectionRoomTest {

    private Player player;
    private ResurrectionRoom resurrectionRoom;
    private FakeUI fakeUI;

    // arrange
    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
        player = new Player.Builder()
                .name("Jonas")
                .health(95)
                .score(0)
                .strength(10)
                .build();

        resurrectionRoom = new ResurrectionRoom();
        fakeUI = new FakeUI();
    }

    @DisplayName("Kontroll - hälsa samt poäng ökar om man har lösenord")
    @Test
    void testPlayerHasPassword() {

        // arrange - spelaren har hittat lösenordet
        player.setFoundPassword(true);
        fakeUI.setInput("ja");

        // act - kör metoden enterRoom
        resurrectionRoom.enterRoom(player,fakeUI);

        // assert - kollar att hälsan ökat 70 HP samt att man fått 30 poäng
        assertEquals(165,player.getHealth());
        assertEquals(30,player.getScore());
    }

    @DisplayName("Kontroll - hälsa ökar om man svarar ja, men inte har lösenord")
    @Test
    void testPlayerAnswerYesHasNoPassword() {

        // arrange - svarar att man har lösenordet, men det har man inte
        fakeUI.setInput("ja");

        // act - kör metoden enterRoom
        resurrectionRoom.enterRoom(player,fakeUI);

        // assert - kollar att hälsan ökar med 10
        assertEquals(105, player.getHealth());
    }


    @DisplayName("Kontroll - hälsan är oförändrad om man svarar nej")
    @Test
    void testPlayerAnswerNo() {

        // arrange - svarar att man inte har lösenordet
        fakeUI.setInput("nej");

        // act - kör metoden enterRoom
        resurrectionRoom.enterRoom(player,fakeUI);

        // assert - kollar att hälsan är oförändrad
        assertEquals(95, player.getHealth());
    }
}