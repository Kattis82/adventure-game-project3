package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class ResurrectionRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du har kommit till vilodungen. Här kan du samla kraft och ladda " +
                "batterierna. För att öppna dörren till mer hälsa behöver du ange lösenordet.");
        String choice = ui.getInput("Har du lösenordet? (ja/nej)");
        if(choice.equalsIgnoreCase("ja")) {
            if(player.hasFoundPassword()) {
                player.addHealth(70);
                ui.showMessage("Din hälsa ökar och du känner dig mycket piggare. Din HP är nu :" + player.getHealth());
                player.addScore(30);
            } else {
                player.addHealth(10);
                ui.showMessage("Fel lösenord! Du får lite extra hälsa som plåster på såret, HP: " + player.getHealth());

            }

        } else {
            ui.showMessage("Du saknar lösenord och lämnar vilodungen.");
        }

    }
}
