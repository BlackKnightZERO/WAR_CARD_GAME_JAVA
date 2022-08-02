package ca.sheridancollege.project;

/**
 * This class +++Insert Description Here+++
 *
 * @author : Arif Faysal
 * @date : 18/04/2022
 */
public class WarPlayer extends Player {
    
    private int score;
    // private ArrayList<Card> playerCard;
    private GroupOfCards groupOfCards;
    
    public WarPlayer(String name) {
        super(name);
    }

    public WarPlayer(String name, int score, GroupOfCards groupOfCards) {
        super(name);
        this.score = score;
        this.groupOfCards = groupOfCards;
    }

    public int getScore() {
        return score;
    }

    public GroupOfCards getGroupOfCards() {
        return groupOfCards;
    }

    public void setGroupOfCards(GroupOfCards groupOfCards) {
        this.groupOfCards = groupOfCards;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override 
    public void play(){
        System.out.println( super.getName() + " joined the game..." );
    }

    @Override
    public String toString() {
        return "WarPlayer [groupOfCards=" + groupOfCards.getCards() + ", score=" + score + "]";
    }


}
