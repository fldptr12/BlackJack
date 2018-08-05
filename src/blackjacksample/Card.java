/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacksample;

/**
 *
 * @author Peter Faludi
 */
public class Card {
    
    private Suit mySuit;
    
    private int myNumber;
    
    /**
     *
     * @param aSuit Suit of the card
     * @param aNumber Number of the card
     */
    public Card(Suit aSuit, int aNumber){

        this.mySuit = aSuit;
        
        if(aNumber >= 1 && aNumber <=13){
            this.myNumber=aNumber;
        }else{
            System.err.println(aNumber + " is not a valid card number ");
            System.exit(1);
        }
        
        
    }
    
    /**
     *
     * @return the number of the card
     */
    public int getNumber(){
        
        return this.myNumber;
    }
     
    public String toString(){
        
        String numStr="ERR";
        
        switch(this.myNumber){
            
            case 2:
                numStr="Two";
                break;
                
            case 3:
                numStr="Three";
                break;
                
            case 4:
                numStr="Four";
                break;
                
            case 5:
                numStr="Five";
                break;            
                
            case 6:
                numStr="Six";
                break;
                
            case 7:
                numStr="Seven";
                break;
                
            case 8:
                numStr="Eight";
                break;
                
            case 9:
                numStr="Nine";
                break;    
                
            case 10:
                numStr="Ten";
                break;
                
            case 11:
                numStr="Jack";
                break;
                
            case 12:
                numStr="Queen";
                break;
                
            case 13:
                numStr="King";
                break;
                
            case 1:
                numStr="Ace";
                break;                                            
             
        }
        
        return numStr + " of " + mySuit.toString();
                
    }
    
    
}
