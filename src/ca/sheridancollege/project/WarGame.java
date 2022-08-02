package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class +++Insert Description Here+++
 *
 * @author : Arif Faysal
 * @date : 18/04/2022
 */
public class WarGame extends Game {
    
    private WarPlayer winner;
    
    ArrayList<Player> players;
    
    private final ArrayList<WarCard> warRoundStackP1 = new ArrayList<>();
    private final ArrayList<WarCard> warRoundStackP2 = new ArrayList<>();
    
    private GroupOfCards g1;
    private GroupOfCards g2;
    
    private ArrayList<Card> c1 = new ArrayList<>();
    private ArrayList<Card> c2 = new ArrayList<>();
    
    private int counterP1 = 0;
    private int counterP2 = 0;
    private int iterator = 0;
    private final int warCardDrawLimit = 5;
    private int start1, end1, start2, end2;
    
    private Player p1;
    private Player p2;
    
    private WarCard warCard1;
    private WarCard warCard2;
    
    private Card card1;
    private Card card2;

    public WarGame(String name) {
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
        
        players = super.getPlayers();
        
        p1 = players.get(0);
        p2 = players.get(1);
        
        g1 = ( ((WarPlayer) p1).getGroupOfCards() );
        g2 =( ((WarPlayer) p2).getGroupOfCards() );

        c1 = g1.getCards();
        c2 = g2.getCards();

        g1.setSize(c1.size());
        g2.setSize(c2.size());
        
        while(!c1.isEmpty() && !c2.isEmpty() ) {
            
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(WarGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("ROUND : "+(++iterator));
            
            card1 = c1.get( c1.size()-1 );
            warCard1 = ((WarCard) card1);

            card2 = c2.get( c2.size()-1 );
            warCard2 = ((WarCard) card2);
            
            System.out.println(p1.getName()+" DRAWS : "+card1);
            System.out.println(p2.getName()+" DRAWS : "+card2);
            
            if( enumToInt(warCard1) == enumToInt(warCard2) ) {
                            
                this.playWarRound();
                
            } else if( enumToInt(warCard1) > enumToInt(warCard2) ) {
                
                System.out.println("-------"+p1.getName()+" WON THE ROUND-------");
                c1.add(0, warCard1);
                c1.add(0, warCard2);
                counterP1++;
                if( !c1.isEmpty() ) {
                    c1.remove(c1.size()-1);
                }
                if( !c2.isEmpty() ) {
                    c2.remove(c2.size()-1);
                }

                
            } else if( enumToInt(warCard1) < enumToInt(warCard2) ) {
                
                System.out.println("-------"+p2.getName()+" WON THE ROUND-------");
                c2.add(0, warCard2);
                c2.add(0, warCard1);
                counterP2++;
                if( !c1.isEmpty() ) {
                    c1.remove(c1.size()-1);
                }
                if( !c2.isEmpty() ) {
                    c2.remove(c2.size()-1);
                }

            } 
            
            
            System.out.println("||| Score: "+p1.getName()+"="+counterP1+" | "+p2.getName()+"="+counterP2+" |||");
            System.out.println("||| TotalCards: "+p1.getName()+"="+c1.size()+" | "+p2.getName()+"="+c2.size()+" |||");
            
            
        }
        
        if( c1.isEmpty() ) {
             ((WarPlayer) p2).setGroupOfCards(g2);
             ((WarPlayer) p2).setScore(counterP2);
             setWinner((WarPlayer) p2);
             this.declareWinner();
        } else if ( c2.isEmpty() ) {
             ((WarPlayer) p1).setGroupOfCards(g1);
             ((WarPlayer) p1).setScore(counterP1);
             setWinner((WarPlayer) p1);
             this.declareWinner();
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
        
        int result;
        
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

    
    private void playWarRound() {
        
        System.out.println("= = = = = = = = W A R = = = = = = = =");
        
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException ex) {
            Logger.getLogger(WarGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( c1.size() <= warCardDrawLimit || c2.size() <= warCardDrawLimit ) {
            
            System.out.println("!!!Very Critical Stage!!!");
            
            if( c1.size() > c2.size() ){
                
                counterP1++;
                
                System.out.println(p1.getName()+" has the heighest cards ~~~~>");
                System.out.println("<<<<<<< "+p1.getName()+" won the WAR round and gained all the cards >>>>>>>");
                
                c1.addAll(c2);
                ((WarPlayer) p1).setGroupOfCards(g1);
                ((WarPlayer) p1).setScore(counterP1);
                setWinner((WarPlayer) p1);
                c2.clear();
                this.declareWinner();
                
            } else if( c1.size() < c2.size() ) {
                
                counterP2++;
                
                System.out.println(p2.getName()+" has the heighest cards ~~~~>");
                System.out.println("<<<<<<< "+p2.getName()+" won the WAR round and gained all the cards >>>>>>>");
                
                c2.addAll(c1);
                ((WarPlayer) p2).setGroupOfCards(g2);
                ((WarPlayer) p2).setScore(counterP2);
                setWinner((WarPlayer) p2);
                c1.clear();
                this.declareWinner();
            }
        } else {
            
            start1 = (c1.size() - 1) ;
            end1 = start1 -  warCardDrawLimit;
            
            start2 = (c2.size() - 1) ;
            end2 = start2 -  warCardDrawLimit;
            
            for(int i = start1; i > end1 ; i--){
                
                card1 = c1.get(i);
                warCard1 = ((WarCard) card1);
                warRoundStackP1.add(warCard1);
                
                if( !c1.isEmpty() ) {
                    c1.remove(c1.size()-1);
                }
                
            }
            
            System.out.println(p1.getName()+" drew 3 cards facing down and 1 card facing up, Last card: "+warRoundStackP1.get(warRoundStackP1.size()-1)  );
            
            for(int i = start2; i > end2 ; i--){
                
                card2 = c2.get(i);
                warCard2 = ((WarCard) card2);
                warRoundStackP2.add(warCard2);
                
                if( !c2.isEmpty() ) {
                    c2.remove(c2.size()-1);
                }
                
            }
            
            System.out.println(p2.getName()+" drew 3 cards facing down and 1 card facing up, Last card: "+warRoundStackP2.get(warRoundStackP2.size()-1)  );
            
            if( this.enumToInt(warRoundStackP1.get(warRoundStackP1.size()-1)) == this.enumToInt(warRoundStackP2.get(warRoundStackP2.size()-1)) ) {
                
                this.playWarRound();
                
            } else if ( this.enumToInt(warRoundStackP1.get(warRoundStackP1.size()-1)) > this.enumToInt(warRoundStackP2.get(warRoundStackP2.size()-1)) ) {
                
                counterP1++;
                System.out.println("<<<<<<< "+p1.getName()+" won the WAR round and gained all the cards >>>>>>>");
                c1.addAll( warRoundStackP1 );
                c1.addAll( warRoundStackP2 );
                
                warRoundStackP1.clear();
                warRoundStackP2.clear();
                
            } else if ( this.enumToInt(warRoundStackP1.get(warRoundStackP1.size()-1)) < this.enumToInt(warRoundStackP2.get(warRoundStackP2.size()-1)) ) {
                
                counterP2++;
                System.out.println("<<<<<<< "+p2.getName()+" won the WAR round and gained all the cards >>>>>>>");
                c2.addAll( warRoundStackP2 );
                c2.addAll( warRoundStackP1 );
                
                warRoundStackP1.clear();
                warRoundStackP2.clear();
                
            }
            
            
        }
    }
    
}
