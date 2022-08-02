package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class +++Insert Description Here+++
 *
 * @author Arif Faysal
 */
public class WarGameOld extends Game {

    private WarPlayer winner;
    
    public WarGameOld(String name){
        super(name);
    }

    public WarPlayer getWinner() {
        return winner;
    }

    public void setWinner(WarPlayer winner) {
        this.winner = winner;
    }
    

    @Override
    public void play() {

        System.out.println("Ready ? Game Started...");
        ArrayList<Player> players = super.getPlayers();
        int counterP1 = 0;
        int counterP2 = 0;
        int iterator = 0;
        
        Player p1 = players.get(0);
        Player p2 = players.get(1);

        GroupOfCards g1 = ((WarPlayer) p1).getGroupOfCards();
        GroupOfCards g2 = ((WarPlayer) p2).getGroupOfCards();

        ArrayList<Card> c1 = g1.getCards();
        ArrayList<Card> c2 = g2.getCards();

        g1.setSize(c1.size());
        g2.setSize(c2.size());

        while(!c1.isEmpty() && !c2.isEmpty() ) {

          System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

          System.out.println("ROUND : "+iterator);

          Card card1 = c1.get(0);
          WarCard warCard1 = ((WarCard) card1);

          Card card2 = c2.get(0);
          WarCard warCard2 = ((WarCard) card2);

          System.out.println(p1.getName()+" DRAWS : "+card1);
          System.out.println(p2.getName()+" DRAWS : "+card2);

          if( enumToInt(warCard1) == enumToInt(warCard2) ) {
               System.out.println("= = = = = = = = W A R = = = = = = = =");
               // implement war logic
               c1.add(warCard1);
               c1.add(warCard2);
               counterP1++;
          } else if( enumToInt(warCard1) > enumToInt(warCard2) ) {
               System.out.println("-------"+p1.getName()+" WON THE ROUND-------");
               c1.add(warCard1);
               c1.add(warCard2);
               counterP1++;
          } else if( enumToInt(warCard1) < enumToInt(warCard2) ) {
               System.out.println("-------"+p2.getName()+" WON THE ROUND-------");
               c2.add(warCard2);
               c2.add(warCard1);
               counterP2++;
          }

          c1.remove(0);
          c2.remove(0);

          iterator++;

          System.out.println("Score: "+p1.getName()+"="+counterP1+" | "+p2.getName()+"="+counterP2);
          System.out.println("TotalCards: "+p1.getName()+"="+c1.size()+" | "+p2.getName()+"="+c2.size());
            
        }

        if( c1.size() == 0 ) {
             ((WarPlayer) p2).setGroupOfCards(g2);
             ((WarPlayer) p2).setScore(counterP2);
             setWinner((WarPlayer) p2);
        } else if ( c2.size() ==0 ) {
             ((WarPlayer) p1).setGroupOfCards(g1);
             ((WarPlayer) p1).setScore(counterP1);
             setWinner((WarPlayer) p1);
        }

    }

    @Override
    public void declareWinner() {
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("Winner: "+ this.winner.getName());
        System.out.println("Score: "+ this.winner.getScore());
        System.out.println("TotalCards: "+ this.winner.getGroupOfCards().getCards().size());
        System.out.println("Cards: "+ this.winner.getGroupOfCards().getCards());
    }
    
    private int enumToInt(WarCard warcard){
        
        int result = 0;
        
        switch(warcard.getRank()){
            case ACE: result = 13;
                 break;  
            case KING: result = 12;
                 break; 
            case QUEEN: result = 11;
                 break; 
            case JACK: result = 10;
                 break;
            case TEN: result = 9;
                 break;
            case NINE: result = 8;
                 break;
            case EIGHT: result = 7;
                 break;
            case SEVEN: result = 6;
                 break;
            case SIX: result = 5;
                 break;
            case FIVE: result = 4;
                 break;
            case FOUR: result = 3;
                 break;
            case THREE: result = 2;
                 break;
            case TWO: result = 1;
                 break;
            default: result = 0;
                 break;   

        }
        
        return result;
    }


}
