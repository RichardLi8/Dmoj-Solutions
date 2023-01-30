import java.util.*;
/**
 *
 * @author richa
 */
public class AreWeThereYet {

    public static int distance(int [] inbetween, int i, int j){
        if(i == j) return 0;
        int sum = 0;
        if(i < j){
            for(int k = i; k < j; k++){
                sum += inbetween[k];
            }
        }
        else{
            for(int k = j; k < i; k++){
                sum += inbetween[k];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] inbetween = new int [4];
        for(int i = 0; i < 4; i++){
            inbetween [i] = input.nextInt();
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(distance(inbetween, i, j) + " ");
            }
            System.out.println("");
        }
    }
}