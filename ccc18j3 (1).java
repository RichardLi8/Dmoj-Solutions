import java.util.*;
/**
 *
 * @author richa
 */
public class AreWeThereYet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] cities = new int [5];
        cities [0] = 0;
        int dist = 0;
        for(int i = 1; i < 5; i++){
            dist += input.nextInt();
            cities [i] = dist;
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(Math.abs(cities[i]-cities[j]) + " ");
            }
            System.out.println("");
        }
    }
    
}