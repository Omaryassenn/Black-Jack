
package blackjack;


import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] player = new Player[4];
    private Card[] deck = new Card[52];
    private Random random = new Random();
    private Scanner in = new Scanner(System.in);
   private int HighScore = 0;
    public Player[] getPlayer() {
        return player;
    }

    public Card[] getDeck() {
        return deck;
    }



    public int getHighScore() {
        return HighScore;
    }


    public void deckcards() {
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card;
                if (j < 10) {
                    card = new Card(i, j, j + 1);
                } else {
                    card = new Card(i, j, 10);

                }
                deck[n] = card;
                n++;
            }
        }
    }


    public Card draw() {
        Card card;
        int x;
        do {
            x = random.nextInt(52);
        } while (deck[x] == null);
            card = deck[x];
        deck[x] = null;
        return card;
    }


    public void setHighScore() {
        for (int i = 0; i < 4; i++) {
            if (player[i].getScore() > HighScore && player[i].getScore() <= 21) {
                HighScore = player[i].getScore();
            }
        }
    }

    public void setPlayerinfo() {
        for (int i = 0; i < 4; i++) {
            player[i] = new Player();
            if (i < 3) {
                System.out.println("Enter player name :");
                player[i].setName(in.next());
            }
            else {
                player[i].setName("dealer");
            }
            player[i].addCard(draw());
            player[i].addCard(draw());

        }

    }


}
