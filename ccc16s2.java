import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author richa
 */
public class TandemBicycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int question = input.nextInt();
        int people = input.nextInt();
        int [] speed1 = new int [people];
        int [] speed2 = new int [people];
        for(int i = 0; i < people; i++){
            speed1[i] = input.nextInt();
        }
        for(int i = 0; i < people; i++){
            speed2 [i] = input.nextInt();
        }
        int total = 0;
        Arrays.sort(speed1);
        Arrays.sort(speed2);
        if(question == 1){
            for(int i = 0; i < people; i++){
                total += Math.max(speed1[i], speed2[i]);
            }
        }
        else{
            for(int i = 0; i < people; i++){
                total += Math.max(speed1[i], speed2[people-i-1]);
            }
        }
        System.out.println(total);
    }
    
}