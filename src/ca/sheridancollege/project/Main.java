package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class +++Insert Description Here+++
 *
 * @author Arif Faysal
 * @date : 18/04/2022
 */
public class Main {
    
    public static boolean isUniqueUsername(ArrayList<Player> warPlayerList, String name) {
        
        for(Player p : warPlayerList) {
            if( p.getName().equalsIgnoreCase(name) ) {
                return false;
            }
        }
        return true;
        
    }
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("WAR CARD GAME JAVA");
        
        int TotalCards = Suit.values().length * Rank.values().length;
    
        ArrayList<Card> deck = CardDeckGenerator.generate();

        GroupOfCards mainDeck = new GroupOfCards(TotalCards, deck);

        mainDeck.shuffle();

        ArrayList<Card> group1 = new ArrayList<>();
        ArrayList<Card> group2 = new ArrayList<>();

        for(int i=0; i<TotalCards; i++) {
            if(i<TotalCards/2){
                group1.add(deck.get(i));
            } else {
                group2.add(deck.get(i));
            }
        }

        GroupOfCards deckSplit1 = new GroupOfCards(group1.size(), group1);
        GroupOfCards deckSplit2 = new GroupOfCards(group2.size(), group2);

        // PLAYER Initialize
        ArrayList<Player> warPlayerList = new ArrayList<>();
        
        Scanner scn = new Scanner(System.in);
        String playerName;
        
        while( warPlayerList.size() <2 ){
            System.out.println("---------------------------------------------------");
            System.out.println("Enter your Name:");
            playerName = scn.next();

            if( playerName.length()> 0 && isUniqueUsername(warPlayerList, playerName) ){
                if(warPlayerList.isEmpty()){
                    Player wp = new WarPlayer(playerName, 0, deckSplit1 );
                    warPlayerList.add(wp);
                    wp.play();
                } else {
                    Player wp = new WarPlayer(playerName, 0, deckSplit2 );
                    warPlayerList.add(wp);
                    wp.play();
                }
                
            }   

        }

        if( warPlayerList.size() == 2 ){
            
            System.out.println("---------------------------------------------------");
            
            WarGame warGame = new WarGame("WAR-CARD-GAME");
            
            System.out.println("Initializing... "+ warGame.getName() );
            
            warGame.setPlayers(warPlayerList);
            
            System.out.println("---------------------------------------------------");
            
            try {
                
                warGame.play();
                
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        }
        
     
    }

}
