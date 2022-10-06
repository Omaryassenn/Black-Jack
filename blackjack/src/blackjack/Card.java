
package blackjack;


public class Card 
{
    private final int suit;
    private final int rank;
    private final int value;

    public Card(int s , int r , int v)
    {
        suit=s;
        rank=r;
        value=v;

    
    }
    public Card(Card card) {
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public int getRank() {
        return rank;
    }
    
}
