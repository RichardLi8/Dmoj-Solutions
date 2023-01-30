import java.util.*;
/**
 *
 * @author richa
 */
public class NotQuitePrime {

    public static boolean prime(int n){
        if(n == 1) return false;
        for(int i = 2; i <= Math.floor(Math.sqrt(n)); i++){
            if(n % i == 0)return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int k = 0; k < 5; k++){
            int n = input.nextInt();
            int count = 0;
            Set <Integer> factors = new HashSet<>();
            for(int i = 2; i <= n; i++){
                if(n % i == 0 && !factors.contains(i)){
                    if(prime(i)) {
                        count++;
                        factors.add(i);
                    }
                    if(prime(n/i)) {
                        count++;
                        factors.add(n/i);
                    }
                }
                if(count > 2) break;
            }
            if(count == 2) System.out.println("semiprime");
            else System.out.println("not");
        }
    }
    
}