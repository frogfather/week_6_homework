package blackjack;
public interface Dealable{
 void populate();
 int getCardCount();
 Card getCard(SuitType suit, int Value);

}