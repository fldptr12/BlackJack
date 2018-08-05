/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacksample;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Peter Faludi
 */
public class Deck {
    
    private LinkedList<Card> myCards = new LinkedList();
    private int numCards;
     
    /**
     * Default constructor without parameters.52 card without shuffle.
     */
    public Deck(){
        
        this(1,false);
        
    }
    
    /**
     *
     * @param numDecks Number of the decks.How many times 52 card.
     * @param shuffle Do you want shuffle the deck?
     */
    public Deck(int numDecks,boolean shuffle){
        
        numCards = numDecks * 52;
        
        for(int i=0;i<numDecks;i++){
            
            for(Suit suit : Suit.values()){
                
                for(int n = 1; n <= 13; n++){
       
                    Card tmpCard = new Card(suit,n);
                    myCards.add(tmpCard);  
                    
                }
            }          
        }
        
        if(shuffle){
            this.shuffle();
        }
    }
    
    /**
     * Shuffling function
     */
    public void  shuffle(){
            
            Random rnd = new Random();
            for(int i = 0; i < this.numCards;i++){
                
                int j = rnd.nextInt(this.numCards);
                Collections.swap(myCards,i,j);
            }
    }
    
    /**
     *
     * @return with the top card of deck
     */
    public Card dealNextCard(){
        
        Card top = this.myCards.getLast();
        this.myCards.removeLast();
        return top;
    }
    
    /**
     *
     * @param numToPrint How many cards do you want print?
     */
    public void printDeck(int numToPrint){
        
        int counter=1;
        Iterator<Card> printList;
        printList = myCards.descendingIterator();
        
        while(printList.hasNext() && numToPrint >= counter){
            System.out.printf("% 3d/%d %s\n",counter,this.numCards,
                   printList.next().toString());
            counter++;
        }
        
        System.out.printf("\t\t [%d other]\n" , this.numCards-numToPrint);
    }
}
