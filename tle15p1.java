import java.util.*;
/**
 *
 * @author richa
 */
public class PowerRankings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String names [] = new String [n];
        int scores [] = new int [n];
        for(int i = 0; i < n; i++){
            names [i] = input.next();
        }
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                scores [j] += input.nextInt();
            }
        }
        Map <Integer, String> times = new HashMap <>();
        for(int i = 0; i < n; i++){
            times.put(scores [i], names [i]);
        }
        Arrays.sort(scores);
        for(int i = n-1; i >= 0; i--){
            System.out.println(n-1-i+3 + ". " + times.get(scores[i]));
        }
    }
    
}