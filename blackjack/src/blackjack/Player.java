
package blackjack;


public class Player 
{
    private String name;
    private int score=0;
    private Card[]card=new Card[11];
   private int n=0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Card[] getCard() {
        return card;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }
    public void addCard(Card c)
    {
        card[n]=c;
        score=score+c.getValue();
        n++;

    }

}
