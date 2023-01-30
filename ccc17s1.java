import java.util.*;
/**
 *
 * @author richa
 */
public class SumGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int team1 [] = new int [n], team2 [] = new int [n];
        for(int i = 0 ; i < n; i++){
            team1 [i] = input.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            team2 [i] = input.nextInt();
        }
        int sum1 = 0;
        int sum2 = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            sum1 += team1[i];
            sum2 += team2[i];
            if(sum1 == sum2)count = i+1;
        }
        System.out.println(count);
    }
    
}