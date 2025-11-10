package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class CaveRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går in i en mörk grotta. Du hör ett troll som flåsar!");
        Troll troll = new Troll("troll",35,0,7);

        while(player.isAlive() && troll.isAlive()) {
            String choice = ui.getInput("Vill du (g)å vidare in i grottan eller (f)ly?");
            if(choice.equalsIgnoreCase("g")) {
                troll.attack(player);
                ui.showMessage("Trollet hoppar på dig och attackerar! Ditt HP: " + player.getHealth());
                if(player.isAlive()) {
                  player.attack(troll);
                  ui.showMessage("Du försvarar dig och attackerar trollet. Trollets HP: " + troll.getHealth());
                }
            } else if (choice.equalsIgnoreCase("f")) {
                ui.showMessage("Du lyckades fly från trollet! Du vinner extra poäng.");
                player.addScore(30);
                player.setDeceivedTroll(true);
                ui.showMessage("Du smyger vidare ut ur grottan.");
                return;
            } else {
                ui.showMessage("Ogiltigt val, försök igen!");
            }
        }

        if (!troll.isAlive()) {
            ui.showMessage("Trollet är besegrat! Du hittar ett lösenord " +
                    "på trollets döda kropp och går ut ur grottan.");
            player.setFoundPassword(true);
        }

        if (!player.isAlive()) {
            ui.showMessage("Trollet besegrade dig... spelet är över.");
        }

    }

}
