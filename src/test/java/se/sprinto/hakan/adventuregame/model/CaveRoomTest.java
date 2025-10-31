package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class CaveRoomTest {

    private Player player;
    private CaveRoom caveRoom;
    private FakeUI fakeUI;


    // arrange
    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
        player = new Player.Builder()
                .name("Soya")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        caveRoom = new CaveRoom();
        fakeUI = new FakeUI();
    }

    @DisplayName("Kontroll - man ska få poäng och deceivedTroll bli sann vid flykt")
    @Test
    void testPlayerFlees() {

        // arrange - flyr från trollet
        fakeUI.setInput("f");

        // act - kör metoden enterRoom
        caveRoom.enterRoom(player,fakeUI);

        // assert - kollar så att man får poäng och deceivedTroll är true vid flykt
        assertTrue(player.hasDeceivedTroll());
        assertEquals(30, player.getScore());
    }

    @DisplayName("Kontroll - spelaren hittar lösenord eller dör vid attack")
    @Test
    void testPlayerFightsTroll() {

        // arrange - går in i grottan
        fakeUI.setInput("g");

        // act - kör metoden enterRoom
        caveRoom.enterRoom(player,fakeUI);

        // assert - kollar att spelaren antingen har lösenordet eller är död
        assertTrue(player.hasFoundPassword() || !player.isAlive());
    }

}