import java.util.ArrayList;

public class player {

    private ArrayList<card> hand;
    static int playerCount;
    private int playerNum;
    private String playerType;

    public player(String playerType) {
        this.hand = new ArrayList<card>();
        this.playerNum = playerCount += 1;
        this.playerType = playerType;
    }



    public int getPlayerNum() {
        return this.playerNum;
    }

    public void addCard(card card){
        hand.add(card);
    }

    public card playCard(card card){
        hand.remove(card);
        return card;
    }



    public String toString(){
        if (playerNum == 1){
            return "Player";
        }
        return "CPU " + (playerNum - 1);
    }

    public ArrayList<card> getHand(){
        return this.hand;
    }
}
