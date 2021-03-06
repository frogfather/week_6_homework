package blackjack;
import java.util.*;

public class Dealer extends Player{

private Dealable deck;

public Dealer(String name, Dealable dealable){
  super(name);
  this.deck = dealable;
}

public void dealCard(Player player){
  Random rand = new Random();
  int i = rand.nextInt(deck.getCardCount()) +1;
  Card card = deck.getCard(i);
  player.takeCard(card);
}



}