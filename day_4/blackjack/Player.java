package blackjack;
import java.util.*;

public class Player {
  private String name;
  private ArrayList<Card> hand;

public Player(String name){
  this.name = name;
  this.hand = new ArrayList<Card>();
  }  

public void takeCard(Card card) {
  this.hand.add(card);
}

public int getHandSize(){
  return this.hand.size();
}

public Card playCard(){
  if (getHandSize() > 0){
    return this.hand.get(0);
  } 
return null;  
}

public int getHandValue(){
  int sum = 0;
  if (getHandSize() > 0){
    for (Card card : hand) {
      sum += card.getValue();
      }
    }
  return sum;  
  }
}