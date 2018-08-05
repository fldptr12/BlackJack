package blackjacksample;


import blackjacksample.Card;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author budah
 */
public class Player {
    
    private String name;
    private LinkedList<Card> hand = new LinkedList();
    
    
    public Player(String aName){
        
        this.name = aName;
        hand.clear();
    }
    
    public boolean addCard(Card aCard){
        
        hand.add(aCard);
        return (getHandSum() >= 21);
        
    }

    private int getHandSum() {
        
        Iterator<Card> iHand;
        iHand = hand.iterator();
        int handSum = 0;
        int numAces = 0;
        int cardNum = 0;
        
        while(iHand.hasNext()){
            cardNum = iHand.next().getNumber();
            if(cardNum == 1){
                handSum += 11;
                numAces++;
            }else if(cardNum >= 10 ){
                handSum += 10;
            }else{
                handSum += cardNum;
            }
        }
        
        while(handSum > 21 && numAces > 0){
            handSum -= 10;
            numAces--;
        }
        
        return handSum; 
    }
    public void printHand(boolean showFirstCard){
        System.out.printf("%s's cards:/n ",this.name);
        Iterator<Card> iCard = hand.iterator();
        while(iCard.hasNext()){
            if(showFirstCard){
                System.out.println(" [hidden]");
                iCard.next();
            }else{
                System.out.printf("  %s/n",iCard.next().toString());
            }
        }
    }
    
    
}
