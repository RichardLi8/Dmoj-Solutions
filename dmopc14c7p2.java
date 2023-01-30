import java.util.Scanner;
/**
 *
 * @author richa
 */
public class Tides {

    public static boolean isValid(int [] num, int min, int max){
        for(int i = min; i < max; i++){
            if(!(num[i] < num [i+1])){
                return false;
            }
        }
        return true;
    }    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num [] = new int [n];
        for(int i = 0; i < n; i++){
            num[i] = input.nextInt();
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(num[i] <= min){
                min = num[i];
                minIndex = i;
            }
            if(num[i] >= max){
                max = num[i];
                maxIndex = i;
            }
        }
        if(minIndex >= maxIndex){
            System.out.println("unknown");
        }
        else if(isValid(num, minIndex, maxIndex)){
            System.out.println(max-min);
        }
        else{
            System.out.println("unknown");
        }
    }
}