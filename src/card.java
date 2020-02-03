public class card implements Comparable<card> {
    private String suit;
    private int face;
    private String name;

    public card(String suit, int face){
        this.suit = suit;
        this.face = face;
        String faceName;
        String suitName;
        switch(face){
            case(1):
                faceName = "Ace";
                break;
            case (11):
                faceName = "Jack";
                break;
            case (12):
                faceName = "Queen";
                break;
            case (13):
                faceName = "King";
                break;
            default:
                faceName = Integer.toString(face);
        }
        switch(suit){
            case("D"):
                suitName = "Diamonds";
                break;
            case("C"):
                suitName = "Clubs";
                break;
            case("H"):
                suitName = "Hearts";
                break;
            case("S"):
                suitName = "Spades";
                break;
            default:
                suitName = "Error";
        }
        name = faceName + " of " + suitName;
    }

    public String toString(){
        return suit + face;
    }

    public int compareTo(card other) {
        int result = Integer.compare(this.face, other.face);
        return result;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getFace(){
        return this.face;
    }

    public String getName(){
        return this.name;
    }
/*
    public static void main(String[] args) {
        card c1 = new card("S",11);
        System.out.println(c1.name);

    }

 */
}
