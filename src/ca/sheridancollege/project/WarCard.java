package ca.sheridancollege.project;

/**
 * This class +++Insert Description Here+++
 *
 * @author : Arif Faysal
 * @date : 18/04/2022
 */
public class WarCard extends Card {
    private Suit suit;
    private Rank rank;

    public WarCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "WarCard [suit=" + suit + ", rank=" + rank + "]";
    }
}
