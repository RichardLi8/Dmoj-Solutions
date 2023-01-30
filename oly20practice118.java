import java.util.*;
/**
 *
 * @author richa
 */
public class Test {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.nextInt();
        }
        int point1 = 0;
        int point2 = n-1;
        int sum1 = 0;
        int sum2 = 0;
        boolean used [] = new boolean [n];
        while(true){
            if(sum1 <= sum2){
                if(!used[point1]){
                    sum1 += nums [point1];
                    used [point1] = true;
                    point1++;
                }
                else break;
            }
            else if(sum1 > sum2){
                if(!used[point2]){
                    sum2 += nums [point2];
                    used [point2] = true;
                    point2--;
                }
                else break;
            }
        }
        System.out.println(Math.abs(sum1-sum2));
    } 
}