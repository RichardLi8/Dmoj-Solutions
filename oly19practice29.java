import java.util.*;
/**
 *
 * @author richa
 */
public class Modulo {

    public static boolean solve(int factor, int divisor, int remainder){
        for(int i = 1; i <= divisor; i++){
            if(factor*i%divisor == remainder) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int factor = input.nextInt();
        int divisor = input.nextInt();
        int remainder = input.nextInt();
        if(solve(factor, divisor, remainder)) System.out.println("YES");
        else System.out.println("NO");
    }
    
}