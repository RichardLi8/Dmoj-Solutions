import java.util.*;
/**
 *
 * @author richa
 */
public class DamageOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long min = input.nextLong();
        long damage [] = new long [n+1];
        for(int i = 1; i <= n; i++){
            damage [i] = input.nextInt();
        }
        for(int i = 1 ; i <= n; i++){
            damage [i] = damage [i] + damage [i-1];
        }
        int count = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        for(int i = right; i <= n; i++){
            right = i;
            if(damage[right]-damage[left] >= min){
                for(int j = left; j <= right; j++){
                    left = j;
                    if(damage[right]-damage[left] < min){
                        break;
                    }
                    else if(count > right-left) count = right-left;
                }
            }
        }
        if(count == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(count);
    }
    
}