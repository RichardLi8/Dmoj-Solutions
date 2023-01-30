import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] readings = new int [2000001];
        int max = Integer.MIN_VALUE;
        int largest = 0;
        for(int i = 0; i < n; i++){
            int reading = input.nextInt();
            readings [reading]++;
            if (readings [reading] > max) {
                max = readings [reading];
                largest = reading;
            }
            else if(readings [reading] == max && reading > largest) largest = reading;
        }
        int second = 1;
        int ans = 0;
        for(int i = 1; i < 2000001; i++){
            if(readings [i] > second && i != largest){
                ans = Math.abs(i - largest);
                second = readings [i];
            }
            else if(readings [i] == second){
                ans = Math.max(Math.abs(i-largest), ans);
            }
        }
        System.out.println(ans);
    }
}