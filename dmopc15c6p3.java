import java.util.*;
/**
 *
 * @author richa
 */
public class Harvest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        long k = input.nextLong();
        long [] rows = new long [n+2];
        for(int i = 0 ; i < m; i++){
            rows [input.nextInt()]--;
            rows [input.nextInt()+1]++;
        }
        rows [1]+= m;
        for(int i = 1; i <= n; i++){
            rows [i] = rows[i]+rows[i-1];
        }
        for(int i = 1; i <= n; i++){
            rows [i] = rows[i]+rows[i-1];
        }
        int right = 1;
        int left = 0;
        int count = Integer.MAX_VALUE;
        for(int i = right; i <= n; i++){
            right = i;
            if(rows [right]-rows [left] >= k){
                for(int j = left; j <= right; j++){
                    left = j;
                    if(rows [right] - rows [left] < k){
                        break;
                    }
                    else if(count > right-left) count = right -left;
                }
            }
        }
        if(count == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(count);
    }
    
}