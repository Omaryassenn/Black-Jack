package blackjack;

import java.util.Scanner;

public class Blackjack {

    static Game game = new Game();
    static Player[] players = game.getPlayer();
    static Scanner in = new Scanner(System.in);
    static GUI gui = new GUI();


    public static void main(String[] args) {
        game.deckcards();
        game.setPlayerinfo();
        game.setHighScore();
        gui.runGUI(game.getDeck(), players[0].getCard(), players[1].getCard(), players[2].getCard(), players[3].getCard());
        player();
        dealer();
        result();
    }

    public static void player() {

        for (int i = 0; i < 3; i++) {

            while (true) {
                System.out.println("hit/stand");
                if (in.next().equals("hit")) {
                    Card c = game.draw();
                    players[i].addCard(c);
                    gui.updatePlayerHand(c, i);
                } else
                    break;

            }
        }
        game.setHighScore();

    }

    public static void dealer() {
        game.setHighScore();

        while (true) {

            if (players[3].getScore() >= 21 || players[3].getScore() > game.getHighScore()) {
                break;
            } else {


                Card c = game.draw();
                players[3].addCard(c);
                gui.updateDealerHand(c, game.getDeck());

            }
        }

    }

    public static void result() {
        int draw = 0;
        int winner = -1;
        game.setHighScore();

        for (int i = 0; i < 4; i++) {
            if (game.getPlayer()[i].getScore() == game.getHighScore()) {
                winner = i;
                draw++;
            }
        }

        if (draw == 1) {
            System.out.println("The Winner is " + game.getPlayer()[winner].getName());
        } else {
            System.out.println("Push");


        }

        for (int i = 0; i < 4; i++) {
            System.out.println(game.getPlayer()[i].getScore());
        }
        System.out.println(game.getHighScore());

    }

}
