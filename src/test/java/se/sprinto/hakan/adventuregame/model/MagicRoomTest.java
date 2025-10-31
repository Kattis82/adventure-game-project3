package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class MagicRoomTest {

    private Player player;
    private MagicRoom magicRoom;
    private FakeUI fakeUI;

    // arrange
    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
        player = new Player.Builder()
                .name("Oscar")
                .health(120)
                .score(0)
                .strength(10)
                .build();

        magicRoom = new MagicRoom();
        fakeUI = new FakeUI();
    }

    @DisplayName("Kontroll - styrkan minska efter trollkarlens attack ")
    @Test
    void testNotPlayGame() {

        // arrange - spelaren vill inte spela spelet med trollkarlen
        fakeUI.setInput("nej");

        // act - kör metoden
        magicRoom.enterRoom(player,fakeUI);

        // assert - strength ska minska efter attacken
        assertTrue(player.getStrength() < 10);
    }

    @DisplayName("Kontroll - styrkan ändras efter trollkarlens spel")
    @Test
    void testPlayGame() {

        // arrange - spelaren vill spela spelet med trollkarlen
        fakeUI.setInput("ja");
        // kollar styrkan innan metoden enterRoom körs
        int strengthBefore = player.getStrength();

        // act - kör metoden
        magicRoom.enterRoom(player,fakeUI);
        // kollar styrkan efter metoden enterRoom körts
        int strengthAfter = player.getStrength();

        // assert - kollar att styrkan har förändrats efter man har spelat spelet
        assertNotEquals(strengthBefore,strengthAfter);
    }

}