import java.util.*;
/**
 *
 * @author richa
 */
public class MimiAndBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = input.nextInt();
        Map <Integer, Integer> amount0 = new HashMap<>();
        Map <Integer, Integer> amount1 = new HashMap<>();
        int ones [] = new int [s.length()+1];
        int zeros [] = new int [s.length()+1];
        for(int i = 1; i <= s.length(); i++){
            zeros [i] = zeros [i-1];
            ones [i] = ones [i-1];
             if(s.charAt(i-1) == '0'){
                 zeros [i]++;
                 amount0.put(zeros [i], i);
             }
             else{
                 ones [i]++;
                 amount1.put(ones[i], i);
             }
        }
        for(int i = 0; i < n; i++){
            int start = input.nextInt();
            int amount = input.nextInt();
            int digit = input.nextInt();
            if(digit == 0){
                if(amount0.containsKey(zeros [start-1]+amount)){
                    System.out.println(amount0.get(zeros [start-1]+amount));
                }
                else System.out.println(-1);
            }
            else{
                if(amount1.containsKey(ones [start-1]+amount)){
                    System.out.println(amount1.get(ones [start-1]+amount));
                }
                else System.out.println(-1);
            }
        }
    }
    
}