package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class +++Insert Description Here+++
 *
 * @author Arif Faysal
 * @modifier : Arif Faysal
 * @date : 18/04/2022
 */
public class CardDeckGenerator {
    
    public static ArrayList<Card> generate() {

        ArrayList<Card> deck = new ArrayList<>();

        for( Suit s : Suit.values() ) {
            for( Rank r : Rank.values() ){

                Card newWarCard = new WarCard(s, r);
                deck.add(newWarCard);
            }
        }

        return deck;
    }
}
