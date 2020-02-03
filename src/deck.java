import java.util.*;


public class deck {
    private Stack<card> deckCards;
    private HashMap<String, card> cardMap;

    public deck() {
        List<String> suits = Arrays.asList("D", "C", "H", "S");
        this.deckCards = new Stack<card>();
        this.cardMap = new HashMap<String, card>();
        for (String suit : suits) {
            for (int i = 1; i < 14; i++) {
                String face = String.valueOf(i);
                deckCards.add(new card(suit, i));
                cardMap.put(suit + face, deckCards.peek());
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deckCards);
        }

    public HashMap<String, card> getCardMap(){
        return cardMap;
    }

    public String toString(){
        return deckCards.toString();
    }

    public card dealCard(){
        return deckCards.pop();
    }

    public void printDeck(){
        System.out.println(deckCards.size());
    }



    /* public static void main(String[] args) {

        game game1 = new game();
        deck d1 = new deck();
        d1.shuffle();
        player player1 = new player("HUMAN");
        player player2 = new player("CPU");
        System.out.println(d1);
        System.out.println(d1.deckCards.peek().getClass());
        System.out.println(d1.cardMap.get("S7"));
        System.out.println(d1.cardMap.get("S7").test());
        game1.initialisePlayers(1);
        System.out.println(game1.getPlayerList());
        //System.out.println(d1.deckCards.size());

    }

     */
}
