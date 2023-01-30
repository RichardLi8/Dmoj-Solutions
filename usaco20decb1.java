import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class Test {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nums [] = new int [7];
        for(int i = 0; i < 7; i++){
            nums [i] = input.nextInt();
        }
        Arrays.sort(nums);
        int A = 0;
        int comb = 0;
        for(int i = 0; i < 6; i++){
            for(int j = i+1; j < 6; j++){
                if(nums [i] + nums [j] == nums [6]){
                    A = nums [i]; comb = nums [j];
                }
            }
            if(A != 0)break;
        }
        int B = 0;
        int C = 0;
        for(int i = 0; i < 6; i++){
            for(int j = i+1; j < 6; j++){
                if(nums [i] + nums [j] == comb){
                    B = nums [i];
                    C = nums [j];
                }
            }
            if(B != 0)break;
        }
        System.out.println(A + " " + B + " " + C);
    }
}