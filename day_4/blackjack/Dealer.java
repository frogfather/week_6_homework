package blackjack;
import java.util.*;

public class Dealer extends Player{

private Dealable deck;

public Dealer(String name, Dealable dealable){
  super(name);
  this.deck = dealable;
}

public void dealCard(Player player){
  Card card = deck.getCard(SuitType.HEART,8);
  player.takeCard(card);
}



}