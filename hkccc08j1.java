import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author richa
 */
public class BestFish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        int cFish [] = new int [c];
        for(int i = 0; i < c; i++){
            int weight = input.nextInt();
            int length = input.nextInt();
            cFish [i] = length * weight;
        }
        int n = input.nextInt();
        int nFish [] = new int [n];
        for(int i = 0; i < n; i++){
            int weight = input.nextInt();
            int length = input.nextInt();
            nFish [i] = length * weight;
        }
        Arrays.sort(nFish);
        Arrays.sort(cFish);
        if(cFish[c-1] > nFish[n-1]){
            System.out.println("Casper");
        }
        else if(cFish[c-1] < nFish[n-1]){
            System.out.println("Natalie");
        }
        else{
            System.out.println("Tie"); 
        }
    }
    
}