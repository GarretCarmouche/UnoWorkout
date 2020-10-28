package unoworkout;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vreyz
 */    
    public class Card{
          private final String cardType; 
          private final String cardColor; 
            
            
    // Constructor 
           public Card(String Type, String Color){
                cardType = Type;
                cardColor= Color;
            }
    
           public String getCardType (){
               return cardType;
           }
    
           public String getCardColor (){
               return cardColor;
           }
           
           public String getCardDescription(){
                    if (cardColor = "")
               return "";
           }
    }
    
