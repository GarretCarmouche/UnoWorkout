package unoworkout;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vrey, Garret
 */    
    public class Card{
          private final String cardType; 
          private final String cardColor;
          private final String description;
            
            
    // Constructor 
           public Card(String Type, String Color){
                cardType = Type;
                cardColor = Color;
                
                String desc;
                switch(cardType){
                    case "Skip":
                        desc = "Skip ";
                        break;
                    case "+2":
                        desc = "Double ";
                        break;
                    case "Reverse":
                        desc = "Cards go back to the pile: ";
                        break;
                    case "Wild":
                        desc = "Four burpees";
                        break;
                    case "+4":
                        desc = "Four burpees. 4x each exercise";
                        break;
                    default:
                        desc = cardType+" ";
                    
                }
                
                switch(cardColor){
                    case "Red":
                        desc = desc + "sit ups";
                        break;
                    case "Blue":
                        desc = desc + "push ups";
                        break;
                    case "Yellow":
                        desc = desc + "squats";
                        break;
                    case "Green":
                        desc = desc + "lounges.";
                        break;
                }
                description = desc;
            }
    
           public String getCardType (){
               return cardType;
           }
    
           public String getCardColor (){
               return cardColor;
           }
           
           public String getCardDescription(){
               return description;
           }
    }
    
