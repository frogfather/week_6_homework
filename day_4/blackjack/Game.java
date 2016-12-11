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
  setPlayers();
  play();
  }

  public void setDealer(){
    Console console = System.console(); 
    boolean done = false;
    while (done == false){ 
      String name = console.readLine("Please enter the name of the dealer... ");
      if (name.length()>0){
        this.dealer = new Dealer(name,this.deck);
        done = true;
        } 
      }

    done = false;
    while (done == false){
      String input = console.readLine("Is the dealer also playing? y/n ");
      if (input.equals("y")) {
        addPlayer(this.dealer);
        }
      done = ((input.equals("y"))||(input.equals("n"))); 
      }
    } 

  public void setPlayers(){
    // need at least 2 players
    Console console = System.console(); 
    boolean done = false;
    String name;
    while (done == false){ 
     if (getPlayerCount() == 0){
      name = console.readLine("Please enter the name of the first player... ");
      } 
    else { 
      name = console.readLine("Please enter the name of the next player... ");
      }
     if (name.length() > 0){
      Player player = new Player(name);
      addPlayer(player);
      if (getPlayerCount() > 1){
        String input = console.readLine("Add another player? y/n ");
       if (input.equals("n")) {
        done = true;
        }
       }
      } 
    }
  }

  public void addPlayer(Player player){
    this.players.add(player);
  }

  public int getPlayerCount(){
    return this.players.size();
    }



  public void play(){
    // for (Type variable: arraylist) {do something}
  Console console = System.console(); 
  Boolean finished = false;
  String stick;
  int activePlayers = getPlayerCount();
  while (finished == false) {
    for (Player player: players){

      System.out.println("Active players "+activePlayers);

      if ((player.getPlayerStick() == false) && (player.getPlayerBust() == false)){
        dealer.dealCard(player);

        if (player.getHandSize() == 1) {
          dealer.dealCard(player);          
        }
      //check score - if bust don't need to ask if wants to stick  
      if (player.getHandValue() > 21){
        player.setPlayerBust(true);
        activePlayers--;  
        System.out.println("Oh dear "+player.getPlayerName()+" is bust! ("+player.getHandValue()+")");    
        }
      else {
       stick = console.readLine(player.getPlayerName()+" has "+player.getHandSize()+" cards, value "+player.getHandValue()+". Stick? y/n ");

       if (stick.equals("y")) {
          player.setPlayerStick(true);
          activePlayers--;
          }
        }
      } 
    else
      {
       if (player.getPlayerStick() == true){
        System.out.println(player.getPlayerName()+" is sticking at "+player.getHandValue());  
       }
       if (player.getPlayerBust() == true){
        System.out.println(player.getPlayerName()+" is bust ");  
       } 
      }  
      if (activePlayers == 0) {finished = true;}
      
    }
  }
  System.out.println(getFinalScores().getPlayerName()+" is the winner - Yay!");  
}

public Player getFinalScores(){
  int highScore = 0;
  Player winner = null;
  highScore = 0;  
  for (Player player: players){
    if (player.getPlayerBust() == false){
      System.out.println(player.getPlayerName()+" has "+player.getHandValue());      
      if (player.getHandValue() > highScore) {
        highScore = player.getHandValue();
        winner = player;
        }
      } 
    }
  return winner;
  }

}

