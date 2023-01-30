import java.util.*;
/**
 *
 * @author richa
 */
public class Hearth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        List <String> cards = new ArrayList<>();
        Map <String, Integer> costs = new HashMap<>();
        for(int i = 0; i < n; i++){
            String card = input.next();
            int cost = input.nextInt();
            if(cost < t){
                cards.add(card);
                costs.put(card, cost);
            }
        }
        Collections.sort(cards);
        if(cards.size() >= 3){
            for(int i = 0; i < cards.size()-2; i++){
                for(int j = i+1; j < cards.size()-1; j++){
                    for(int k = j+1; k < cards.size(); k++){
                        if(costs.get(cards.get(i)) + costs.get(cards.get(j)) + costs.get(cards.get(k)) <= t){
                            System.out.println(cards.get(i) + " " + cards.get(j) + " " + cards.get(k));
                        }
                    }
                }
            }
        }
    }
}