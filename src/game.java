import java.util.ArrayList;
import java.util.Collections;


public class game {
    private player winner;
    private player currentPlayer;
    private player nextPlayer;
    private ArrayList<card> river;
    private ArrayList<player> playerList;
    private ArrayList<card> validCards = new ArrayList<card>();


    private game() {
        this.river = new ArrayList<card>();
    }

    public player getNextPlayer(){
        if (this.currentPlayer.getPlayerNum() -1 == playerList.size() -1) {
            this.nextPlayer = getPlayerList().get(0);
        } else {
            this.nextPlayer = getPlayerList().get(currentPlayer.getPlayerNum());
        }
        return nextPlayer;
    }


    public void initialisePlayers(int playerNum){
        this.playerList = new ArrayList<player>();
        playerList.add(new player("HUMAN"));
        for(int i = 0; i < playerNum; i++){
            playerList.add(new player("CPU"));
        }
    }

    public ArrayList<card> showPlayedCards() {
        Collections.sort(river);
        return river;
    }

    public void checkForWinner(){
        if (currentPlayer.getHand().size() == 0){
            this.winner = currentPlayer;
        }
    }

    public void getValidCards(deck d1,card playedCard){
        card higherCard = d1.getCardMap().get((playedCard.getSuit() + (playedCard.getFace() + 1)));
        card lowerCard = d1.getCardMap().get((playedCard.getSuit() + (playedCard.getFace() - 1)));
        if (!this.river.contains(higherCard)){
            this.validCards.add(higherCard);
        }
        if (!this.river.contains(lowerCard)){
            this.validCards.add(lowerCard);
        }


        //  add sevens


        System.out.println("Valid Cards = " + this.validCards);
    }



    public static void main(String[] args) {
        game game1 = new game();
        game1.winner = null;
        deck d1 = new deck();
        d1.shuffle();
        userInput playerNumPrompt = new userInput();
        int playerNum = playerNumPrompt.getInputInt();
        int cardsToDeal = (49 / (playerNum +1));
        game1.initialisePlayers(playerNum);
        for (int i = 0; i < (cardsToDeal); i++) {
            for (player player:game1.playerList){
                card dealtCard = d1.dealCard();
                if (dealtCard.toString().equals("S7")) {
                    game1.currentPlayer = player;
                    System.out.println(game1.currentPlayer.toString() + " has the 7 of Spades and will start the game.");
                    System.out.println("The next player is " + game1.getNextPlayer().toString());
                    game1.river.add(game1.currentPlayer.playCard(d1.getCardMap().get("S7")));
                    card playedCard =  game1.river.get(game1.river.size() - 1);
                    game1.getValidCards(d1,playedCard);
                }
                player.addCard(dealtCard);
            }
        }
        while (game1.winner == null) {
            for (player player:game1.playerList){
                int playedACard = 0;
                System.out.println("hand = " + player.getHand());
                for (card card:player.getHand()){
                    if (game1.validCards.contains(card)){
                        game1.river.add(game1.currentPlayer.playCard(card));
                        card playedCard = game1.river.get(game1.river.size() - 1);
                        game1.validCards.remove(playedCard);
                        System.out.println(game1.currentPlayer.getPlayerNum() + " played the " + playedCard.getName());
                        game1.getValidCards(d1,playedCard);
                        System.out.println("The new valid cards are " + game1.validCards);
                        playedACard = 1;
                        break;
                    }
                    if (playedACard == 0){
                        System.out.println(game1.currentPlayer.toString() + " had no valid cards to play and had to pass!");
                    }
                }
            }
        }

        // System.out.println(game1.playerList.get(0).getHand());
        System.out.println("River = " + game1.showPlayedCards());
    }







    public ArrayList<player> getPlayerList(){
        return this.playerList;
    }



}
