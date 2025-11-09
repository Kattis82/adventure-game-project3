package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

import java.util.Random;

public class MagicRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kommer fram till ett högt torn. Du öppnar dörren och " +
                "går upp för alla trapporna. En trollkarl sitter högst upp i tornet.");
        Wizard trollkarl = new Wizard("Saruman",150,0,15);

        String choice = ui.getInput("Vill du spela ett spel med trollkarlen? (ja/nej)");

        if(choice.equalsIgnoreCase("nej")) {
            trollkarl.attack(player);
            ui.showMessage("Trollkarlen blir arg, attackerar och tar styrka från dig! "+
                    "Nu har du " + player.getStrength() + " kvar i styrka." +
                    " Du känner att din kraft minskar, men försvarar dig. ");
            player.attack(trollkarl);
            ui.showMessage("Trollkarlen har mycket HP kvar (" + trollkarl.getHealth() + "), så du flyr från tornet. ");
            return;
        }

        Random random = new Random();
        int game = random.nextInt(100);
        if(game<70) {
            int win = 10;
            player.addStrength(win);
            ui.showMessage("Trollkarlen skrattar glatt. Du vann! Du får " + win +
                    " extra i styrka. Din nya styrka är: " + player.getStrength());
        } else {
            int loss = 5;
            int newStrength = Math.max(1, player.getStrength() -loss);
            player.setStrength(newStrength);
            ui.showMessage("Trollkarlen skrattar elakt. Du förlorade! Du förlorar "
                    + loss + " styrka. Din nya styrka är: " + player.getStrength());
        }


    }
}
