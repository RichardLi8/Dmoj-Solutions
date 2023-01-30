import java.util.*;
/**
 *
 * @author richa
 */
public class ComputingTournament {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Map <Integer, Integer> scores = new HashMap<>();
        Map <Integer, Integer> index = new HashMap<>();
        int [] values = new int [n];
        for(int i = 0; i < n; i++){
            values [i] = input.nextInt();
            int second = input.nextInt();
            scores.put(values [i], second);
            index.put(second, i+1);
        }
        Arrays.sort(values);
        int round2 [] = new int [k];
        for(int i = n-1; i >= n-k; i--){
            round2 [n-1-i] = scores.get(values[i]);
        }
        Arrays.sort(round2);
        System.out.println(index.get(round2 [round2.length-1]));
    }
}