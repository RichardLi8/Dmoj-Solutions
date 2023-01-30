import java.util.*;

public class HelloWorld {
    
    public static void check(List <String> deck, int cards){
        if(deck.size() < cards) return;
        String highcards = "king, queen, jack, ace";
        for(int i = 0; i < cards; i++){
            if(highcards.contains(deck.get(i))) return;
        }
        String player = "";
        if(deck.size()%2 == 1) {
            player = "A";
            scoreA += cards;
        }
        else {
            player = "B";
            scoreB += cards;
        }
        System.out.println("Player " + player + " scores " + cards + " point(s).");
    }
    static int scoreA = 0;
    static int scoreB = 0;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List <String> deck = new LinkedList<>();
        for(int i = 0; i < 52; i++){
            deck.add(input.nextLine());
        }
        String highcards = "king, queen, jack, ace";
        while(!deck.isEmpty()){
            String cur = deck.remove(0);
            if(highcards.contains(cur)){
                if(cur.equals("ace")) check(deck, 4);
                else if(cur.equals("king")) check(deck, 3);
                else if(cur.equals("queen")) check(deck, 2);
                else if(cur.equals("jack")) check(deck, 1);
            }
        }
        System.out.println("Player A: " + scoreA + " point(s).");
        System.out.println("Player B: " + scoreB + " point(s).");
    }
}