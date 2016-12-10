package blackjack;
import java.util.*;
import java.io.Console;

public class Game{
  private Dealable deck;
  private ArrayList<Player> players;
  private Dealer dealer;

  public Game(){
  this.deck = new Deck();
  this.players = new ArrayList<Player>();
  setDealer();
//  setPlayers();
  }

  public void setDealer(){
    Console console = System.console(); 

    boolean named = false;
    while (named == false){ 
      String name = console.readLine("Please enter the name of the dealer... ");
      if (name.length()>0){
        this.dealer = new Dealer(name,this.deck);
        named = true;
        } 
      }

    boolean done = false;
    while (done == false){
      String input = console.readLine("Is the dealer also playing? y/n ");
      if (input.equals("y")) {
        addPlayer(this.dealer);
        }
      System.out.println("Players "+Integer.toString(getPlayerCount()));
      done = ((input.equals("y"))||(input.equals("n"))); 
      }

  }

  public void addPlayer(Player player){
    this.players.add(player);
  }

  public int getPlayerCount(){
    return this.players.size();
    }

}

