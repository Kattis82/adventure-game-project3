package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class StartRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du befinner dig i start-rummet. Du ser sex dörrar framför dig.");
        boolean exit = false;
        while (!exit) {
            String choice = ui.getInput("Vilken dörr vill du ta? (1=Skog, 2=Fängelse, 3=Skattkammare," +
                    " 4=Grotta, 5=Vilodunge, 6=Magiskt torn, q=avsluta)");
            switch (choice) {
                case "1":
                    if (!player.hasFoundKey()) {
                        new ForestRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och plockat upp nyckeln.");
                    }

                    break;
                case "2":
                    new DungeonRoom().enterRoom(player, ui);
                    break;
                case "3":
                    if (!player.hasOpenedChest()) {
                        new TreasureRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och öppnat kistan");
                    }
                    break;
                case "4":
                    if(!player.hasFoundPassword()) {
                        new CaveRoom().enterRoom(player, ui);
                    } else {
                        ui.showMessage("Du har redan besegrat trollet och funnit lösenordet");
                    }
                    break;
                case "5":
                    if(!player.hasFoundPassword()){
                        ui.showMessage("Välkommen in! Med ett lösenord finns här stora möjligheter ");
                    }
                    new ResurrectionRoom().enterRoom(player, ui);
                    break;
                case "6":
                    new MagicRoom().enterRoom(player, ui);
                    break;
                case "q":
                    exit = true;
                    break;
                default:
                    ui.showMessage("Ogiltigt val.");
            }
            if (player.hasWon()) {
                ui.showMessage("Grattis! Du har klarat spelet!");
                exit = true;
            } else if (player.getHealth() <= 0) {
                ui.showMessage(("Din hälsa är kritisk, du vacklar till och dör!"));
                exit = true;
            }
        }
    }
}

